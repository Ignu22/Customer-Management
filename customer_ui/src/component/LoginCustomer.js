import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import CustomerService from '../services/CustomerService'

const LoginCustomer = () => {

  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const navigate = useNavigate()

  const customerLogin = (e) => {
    e.preventDefault()
    const login = {email, password}
    console.log(login)
    CustomerService.loginCustomer(login).then((response) => {
      console.log(response.data)
      navigate('/customer')

    }).catch(error =>{
      console.log(error)
    })
  }


  return (
    <div>
        <br/><br/>
    <div className='container'>
        <div className="row">
          <div className="card col-md-4 offset-md-3  offset-md-3">
            <h2 className="text-center">Login</h2>
            <div className='card-body'>
                <form>
                    <div className="form-group mb-2">
                    <label className="form-label"> Email Id :</label>
                        <input
                            type="text"
                            placeholder="Enter Email Id"
                            name="Name"
                            className="form-control"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        ></input>
                    </div>
                    <div className="form-group mb-2">
                    <label className="form-label"> Password :</label>
                        <input
                            type="text"
                            placeholder="Enter Password"
                            name="Name"
                            className="form-control"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        ></input>
                    </div>
                    <button className="btn btn-success" onClick={(e) => customerLogin(e)}>Login</button>
                    <Link to={"/signup"} className = "btn btn-primary mb-2" >Sign Up</Link> 
                </form>
            </div>
          </div>
        </div>
    </div>
    </div>
  )
}

export default LoginCustomer