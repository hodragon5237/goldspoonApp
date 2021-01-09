  
import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import { Menu, Segment } from 'semantic-ui-react'

import styled from 'styled-components';

const Wrapper = styled.div`
  height: 2rem;
`;

export default class HeaderLayout extends Component {
  state = { activeItem: 'home' }

  handleItemClick = (e, { name }) => {
    this.setState({ activeItem: name });

  
  }

  render() {
    const { activeItem } = this.state

    return (
      <Wrapper>
        <Segment inverted>
          <Menu pointing secondary inverted>
            <Menu.Item
              link
              active={activeItem === 'home'}
              onClick={this.handleItemClick}
            >
              <Link to="/">HOME</Link>
            </Menu.Item>
            <Menu.Item
              link
              active={activeItem === 'TM'}
              onClick={this.handleItemClick}
            >
              <Link to="/orderMap">OrderMapView</Link>
            </Menu.Item>
          </Menu>
        </Segment>
      </Wrapper>
    )
  }
}