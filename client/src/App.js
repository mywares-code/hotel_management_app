import {Fragment, useEffect} from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import {loadUser} from './actions/auth';
import {Provider} from 'react-redux';

import FirstPage from './components/firstpage/FirstPage';
import Register from './components/auth/Register';
import Login from './components/auth/Login';
import AdvancedSearch from './components/search/AdvancedSearch';

import setAuthToken from './utils/setAuthToken';
import store from './store';

import 'bootstrap/dist/css/bootstrap.min.css';
import '@coreui/coreui/dist/css/coreui.min.css';
import '@coreui/coreui/dist/js/coreui.js';
import NotFound from "./components/error/NotFound";
import SecuredPage from "./components/auth/SecuredPage";

if (localStorage.token) {
  setAuthToken(localStorage.token);
}

const App = () => {
  // useEffect(() => {
  //   store.dispatch(loadUser());
  // }, []);

  return (
    <Provider store={store}>
      <Fragment>
        <Router>
          <Routes>
            <Route path='/' element={<FirstPage/>}/>
            <Route path='/sign-in' element={<Login/>}/>
            <Route path='/sign-up' element={<Register/>}/>
            <Route path='/search' element={<AdvancedSearch />} />
            <Route path='/not-found' element={<NotFound />} />
            <Route path='/protected'
                   element={
              <SecuredPage>
                <AdvancedSearch/>
              </SecuredPage>
            } />

          </Routes>
        </Router>
      </Fragment>
    </Provider>
  );
};

export default App;
