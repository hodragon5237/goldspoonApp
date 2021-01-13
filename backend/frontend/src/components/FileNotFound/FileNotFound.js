import React from 'react';
import { Icon } from 'semantic-ui-react';

import Layout from '../../layouts/Layout';

const FileNotFound = () => {
  return (
    <Layout>
      <Layout.Main>
        <Icon name="minus circle" size="big" />
        <strong>Page not found!</strong>
      </Layout.Main>
    </Layout>
  );
};

export default FileNotFound;