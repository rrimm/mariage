import styled from '@emotion/styled';
import { Link } from 'react-router-dom';

const Drink = styled.div`
  width: 15%;
  float: left;
  margin: 0 20px;
  font-size: 1rem;
  text-align: center;
  margin-top: 25px;
  box-sizing: border-box;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
  color: black;
  height: 100%;
  width: 10%;
  min-width: 100px;

  &: hover {
    /* color: #bb2649; */
    color: #9c94d0;
    font-weight: bold;
  }
`;

const RegionText = styled.p`
  font-weight: bold;
`;

export { Drink, StyledLink, RegionText };
