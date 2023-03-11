import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import CustomerService from '../services/CustomerService'

const SignUpCustomer = () => {

    const [name, setName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const navigate = useNavigate()

    const registerCustomer = (e) => {
        e.preventDefault()
        const signup = {name,email,password}
        console.log(signup)
        CustomerService.signupCustomer(signup).then((response) =>{
            console.log(response.data)
            navigate("/login")
        })
    }

    return (
        <div>
            <br />
            <br />
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h2 className="text-center">Sign Up</h2>
                        <div className="card-body">
                            <form>
                                <div className="form-group mb-2">
                                    <label className="form-label"> Name :</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Name"
                                        name="Name"
                                        className="form-control"
                                        value={name}
                                        onChange={(e) => setName(e.target.value)}
                                    ></input>
                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label"> Email :</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Phone Number"
                                        name="email"
                                        className="form-control"
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                    ></input>
                                </div>
                                <div className="form-group mb-2">
                                    <label className="form-label"> Password :</label>
                                    <input
                                        type="text"
                                        placeholder="Enter Street"
                                        name="Password"
                                        className="form-control"
                                        value={password}
                                        onChange={(e) => setPassword(e.target.value)}
                                    ></input>
                                </div>
                                <button className="btn btn-success" onClick={(e) => registerCustomer(e)}>Submit</button>
                                <Link to="/login" className="btn btn-danger "> Cancel </Link>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SignUpCustomer