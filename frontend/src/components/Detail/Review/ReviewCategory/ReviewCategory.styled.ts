import styled from '@emotion/styled';
import { css } from '@emotion/react';

type Sort = {
  sort: boolean;
};

const Container = styled.div`
  margin: 0 auto;
  padding: 40px 0 0;
`;

const Wrapper = styled.div`
  width: 95%;
  height: 100%;
  margin: 0 auto;
  padding: 0;
  overflow: hidden;
`;

const Title = styled.div`
  display: inline-block;
  width: auto;
  vertical-align: bottom;
  margin-right: 10px;
`;

const title_left = css`
  width: 40px;
  height: 40px;
`;

const TitleIcon = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

const title_right = css`
  width: auto;
  height: auto;
  font-size: 1.7rem;
`;

const Bottom = styled.div`
  width: auto;
  height: 50px;
  margin: 15px 0 20px;
  overflow: hidden;
  
`;

const FloatWrap = styled.div`
  float: left;
  padding-top: 5px;
`;

const SelectBox = styled.select`
  outline: none;
  border: none;
  border-radius: 70px;
  box-sizing: border-box;
  box-shadow: 1px 1px 3px #9C94D055;
  background: url('https://i.esdrop.com/d/f/CeyD9bnnT5/1Kum5nNwU4.png') no-repeat 95% 50%; 
  background-size: 13% auto;
  width: 160px;
  height: 40px;
  margin-right: 30px;
  padding-left: 7px;
  font-size: 1rem;
  transition: 250ms;

  &:hover,
  &:focus { 
    box-shadow: 1.5px 1.5px 3px #9C94D0;
    background-color: rgba(156. 148, 208, 0.5);
  }
  &:disabled {
      opacity: 0.5;
      pointer-events: none;
  }
  &::-ms-expand { display: none; }
  -webkit-appearance: none; 
  -moz-appearance: none;
  appearance: none; 
`;

const Option = styled.option`
  padding: 6px 8px;
  transition: background-color 0.2s ease-in;
`;

const Sort = styled.div`
`;

const Button = styled.button<Sort>`
border-radius: 70px;
width: 140px;
min-width: 100px;
height: 40px;
margin-right: 15px;
padding: 0 20px;
font-size: 1rem;

background-color: ${prop => (prop.sort ? '#9c94d0' : '#fff')};
color: ${prop => (prop.sort ? '#f8f8f8' : '#000')};
box-shadow: 1px 1px 3px ${prop => (prop.sort ? '#00000030' : '#9C94D055')};
transition: 250ms;

&:hover {
  box-shadow: 1.5px 1.5px 3px #9C94D0;
}
`;

export {
  Container,
  Wrapper,
  Title, 
  title_left,
  TitleIcon,
  title_right,
  Bottom,
  FloatWrap,
  SelectBox,
  Option,
  Sort,
  Button
};