import React from 'react';
import { Icon, Header } from 'semantic-ui-react';

import Layout from '../../layouts/Layout';

const FileNotFound = () => {
  return (
    <Layout>
      <Icon name="minus circle" size="big" />
      <strong>Page not found!</strong>
    </Layout>
  );
};

export default FileNotFound;