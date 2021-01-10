  
import React from 'react';
import {
  Button,
  Container,
  Divider,
  Grid,
  Header,
  Icon,
  Image,
  List,
  Menu,
  Segment,
  Sidebar,
  Visibility,
} from 'semantic-ui-react'

import styled from 'styled-components';

import HeaderLayout from './Header';
import FooterLayout from './Footer';

const Wrapper = styled.div`
  padding-top: 0px;
  marginTop: '7em';
  height: 80%;
`;

const Layout = ({ children }) => {
  return (
    <Container>
        <HeaderLayout/>
        <Wrapper>
          {children}
          <Divider />
        </Wrapper>
        <FooterLayout/>
    </Container>
  );
};

Layout.Main = styled.div`
    margin: 0 auto;
    margin-top: 2rem;
    position: relative;
    text-align: center;
    background: white;
`;

export default Layout;