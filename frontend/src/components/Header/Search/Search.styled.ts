import styled from '@emotion/styled';

const Container = styled.div`
  display: flex;
  align-items: center;
  width: 30%;
  min-width: 192px;
`;

const Input = styled.input`
  width: 80%;
  height: 42px;
  border: 0;
  border-bottom: 2px solid #00000050;
  font-size: 16px;
  transition: 100ms;

  &:focus {
    outline: none;
    border-bottom: 3px solid #9c94d0;
  }
`;

export { Container, Input };
