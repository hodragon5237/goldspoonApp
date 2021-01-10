import React from 'react';
import { Container } from 'semantic-ui-react';

import Layout from '../../layouts/Layout';

const GoldSpoon = () => {
  return (
    <Layout>
      <Layout.Main>
        <Container textAlign="center">
          <h1>금수저 검사 페이지</h1>
        </Container>
      </Layout.Main>
    </Layout>
  );
};

export default GoldSpoon;