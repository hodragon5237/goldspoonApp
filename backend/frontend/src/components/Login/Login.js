import React from 'react'
import { Button, Form, Grid, Header, Image, Message, Segment } from 'semantic-ui-react'

import Layout from '../../layouts/Layout';

const LoginForm = () => (
  <Layout>
    <Layout.Main>
        <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
            <Grid.Column style={{ maxWidth: 450 }}>
            <Header as='h2' color='teal' textAlign='center'>
                로그인
            </Header>
            <Form size='large'>
                <Segment stacked>
                <Form.Input fluid icon='user' iconPosition='left' placeholder='E-mail address' />
                <Form.Input
                    fluid
                    icon='lock'
                    iconPosition='left'
                    placeholder='Password'
                    type='password'
                />

                <Button color='teal' fluid size='large'>
                    로그인
                </Button>
                </Segment>
            </Form>
            <Message>
                아직 회원이 아니신가요? <a href='/register'>회원 가입</a>
            </Message>
            </Grid.Column>
        </Grid>
    </Layout.Main>
  </Layout>

)

export default LoginForm