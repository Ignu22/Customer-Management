import React,{useState, useEffect} from 'react'
import { Link } from 'react-router-dom';
import CustomerService from '../services/CustomerService';

const CustomerList = ()  => {

  const [customers, setCustomer] = useState([])

  useEffect(() => {
    getAllCustomer();
  }, [])
  
  const getAllCustomer=()=>{
    CustomerService.getAllCustomer().then((response)=>{
        setCustomer(response.data)
        console.log(response.data)
    }).catch(error=>{
        console.log(error)
    })
  }

  return (
    <div className='container'>
        <h2 className='text-left'>Customer Details</h2>
         <Link to={"/add-customer"} className = "btn btn-primary mb-2" >Add Customer</Link> 
              <table className='table table-bordered table-striped'>
            <thead>
                <th> Customer id</th>
                <th> Customer Name</th>
                <th> Customer Number</th>
                <th> Street</th>
                <th> City</th>
                <th> State</th>
                <th> Country</th>
                <th> Description</th>
            </thead>
            <tbody>
                {
                    customers.map(
                        customer =>
                        <tr key={customer.id}>
                            <td> {customer.id}</td>
                            <td> {customer.name}</td>
                            <td> {customer.phone}</td>
                            <td> {customer.address.street}</td>
                            <td> {customer.address.city}</td>
                            <td> {customer.address.state}</td>
                            <td> {customer.address.country}</td>
                            <td> {customer.description}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default CustomerList