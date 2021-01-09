/* src/App.js */
import React from 'react';
import { Switch, BrowserRouter as Router, Route } from 'react-router-dom';

import Home from './components/Home/Home';
import FileNotFound from './components/FileNotFound/FileNotFound';

function App() {
  return (
    <Router>
      <Switch>
        <Route
          exact path="/"
          component={ Home }
        />
        <Route component={ FileNotFound }/>
      </Switch>
    </Router>
  );
}

export default App;