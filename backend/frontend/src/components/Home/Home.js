import React from 'react';
import { Container } from 'semantic-ui-react';

import Layout from '../../layouts/Layout';

const Home = () => {
  return (
    <Layout>
      <Layout.Main>
        <Container textAlign="center">
          <h1>827 Project의 웹 페이지</h1>
        </Container>
      </Layout.Main>
    </Layout>
  );
};

export default Home;