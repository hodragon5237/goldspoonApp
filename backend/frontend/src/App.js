/* src/App.js */
import React, { useState, useEffect } from 'react';
import { Switch, BrowserRouter as Router, Route } from 'react-router-dom';

import AuthRoute from './routes/AuthRoute';

import Home from './components/Home/Home';
import GoldSpoon from './components/GoldSpoon/GoldSpoon';
import LoginForm from './components/Login/Login';
import Register from './components/Register/Register';
import FileNotFound from './components/FileNotFound/FileNotFound';

function App() {

  const [user, setUser] = useState(null);
  const authenticated = user != null;

  return (
    <Router>
      <Switch>
        <Route
          exact path="/"
          component={ Home }
        />
        <AuthRoute
          authenticated={authenticated}
          exact path="/goldspoon"
          component={ GoldSpoon }
        />
        <Route
          exact path="/login"
          component={ LoginForm }
        />
        <Route
          exact path="/register"
          component={ Register }
        />
        <Route component={ FileNotFound }/>
      </Switch>
    </Router>
  );
}

export default App;