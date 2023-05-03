import { useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';

import { requestLogin } from '@/apis/request/auth';
import { Token } from '@/types/user';
import useAuth from '@/hooks/useAuth';
import { BROWSER_PATH } from '@/constants/path';

import * as S from './Login.styled';

function Login() {
  const navigate = useNavigate();

  const { setLogin, setAuth } = useAuth();

  const [isValid, setIsValid] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  const emailRef = useRef<HTMLInputElement>(null);
  const passwordRef = useRef<HTMLInputElement>(null);

  const validateInput = (
    emailRef: React.RefObject<HTMLInputElement>,
    passwordRef: React.RefObject<HTMLInputElement>,
  ) => {
    const email = emailRef.current?.value;
    const password = passwordRef.current?.value;

    if (email?.length === 0) {
      setIsValid(true);
      setErrorMessage('이메일을 입력해주세요.');
      emailRef.current?.focus();
      return true;
    }

    if (password?.length === 0) {
      setIsValid(true);
      setErrorMessage('비밀번호를 입력해주세요.');
      passwordRef.current?.focus();
      return true;
    }

    return false;
  };

  const login = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (
      !emailRef.current ||
      !passwordRef.current ||
      validateInput(emailRef, passwordRef)
    ) {
      return;
    }

    const email = emailRef.current.value;
    const password = passwordRef.current.value;

    requestLogin({ email, password })
      .then(response => {
        const token: Token = {
          accessToken: response.data.accessToken,
          refreshToken: response.data.refreshToken,
        };
        setLogin(true);
        setAuth(token);
        navigate(-1);
      })
      .catch(error => {
        setIsValid(true);
        setErrorMessage(error.response.data.message);
      });
  };

  return (
    <S.Container>
      <S.StyledLink to={BROWSER_PATH.BASE}>
        <S.Header>Mariage</S.Header>
      </S.StyledLink>
      <S.Form onSubmit={login}>
        <S.Label>이름</S.Label>
        <S.Input type={'text'} ref={emailRef} />
        <S.Label>비밀번호</S.Label>
        <S.Input type={'password'} ref={passwordRef} />
        {isValid && <S.ErrorMessage>{errorMessage}</S.ErrorMessage>}
        <S.Button type={'submit'}>로그인</S.Button>
      </S.Form>
    </S.Container>
  );
}

export default Login;
