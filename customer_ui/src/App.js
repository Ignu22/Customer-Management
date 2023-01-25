import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
//import {BrowserRouter,Routes,Route} from 'react-router-dom'
import CustomerList from './component/CustomerList';
import Header from './component/Header';
import AddCustomer from './component/AddCustomer';
import LoginCustomer from './component/LoginCustomer';

function App() {
  return (
    <div>
      <BrowserRouter>
      <Header/>
      <Routes>
        <Route path='/' element={<LoginCustomer/>}/>
        {/*<Route path='/' element={<CustomerList/>}/>
        <Route path='/customer' element={<CustomerList/>}/>
  <Route path='/add-customer' element={<AddCustomer/>}/>*/}
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
