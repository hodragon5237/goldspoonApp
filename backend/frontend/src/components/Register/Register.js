import React, { useState } from 'react';
import { Button, Form, Grid, Header, Image, Message, Segment } from 'semantic-ui-react';
import { Redirect } from "react-router-dom";


import Layout from '../../layouts/Layout';
import { postRequest } from '../../Request';
import RESPONSE_STATUS from '../../configs/request.json';

const Register = () => {

    const [email, setEmail] = useState("")
    const [name, setName] = useState("")
    const [password, setPassword] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault();

        const data = {
            "email": email,
            "name": name,
            "password": password
        }

        const config = {
            "Content-type": "application/json"
        }

        postRequest("/api/account", data, config)
            .then(response => {
                if (response.state == RESPONSE_STATUS.OK) {
                    return <Redirect to={"/login"} />
                }
            })
            .catch(error => {
                console.log(error);
            }) 
    }

    return (
        <Layout>
            <Layout.Main>
                <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
                    <Grid.Column style={{ maxWidth: 450 }}>
                    <Header as='h2' color='teal' textAlign='center'>
                        회원가입
                    </Header>
                    <Form size='large'>
                        <Segment stacked>
                        <Form.Input fluid icon='user' iconPosition='left' placeholder='E-mail address' value={email} onChange={(e) => setEmail(e.target.value)}/>
                        <Form.Input fluid placeholder='name' value={name} onChange={(e) => setName(e.target.value)}/>
                        <Form.Input
                            fluid
                            icon='lock'
                            iconPosition='left'
                            placeholder='Password'
                            type='password'
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />

                        <Button color='teal' fluid size='large' onClick={handleSubmit}>
                            회원 가입
                        </Button>
                        </Segment>
                    </Form>
                    </Grid.Column>
                </Grid>
            </Layout.Main>
        </Layout>
    )

}

export default Register