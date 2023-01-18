import React, { useState } from "react";
import {Link, useNavigate} from "react-router-dom"
import CustomerService from "../services/CustomerService";

const AddCustomer = () => {
  const [name, setName] = useState("");
  const [phone, setphone] = useState("");
  const [street, setStreet] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [country, setCountry] = useState("");
  const [description, setDescription] = useState("");
  const navigate = useNavigate();

  const saveCustomer = (e) => {
    e.preventDefault();
    const address = {street, city, state, country}
    const customers = {name, phone, address, description}
    console.log(customers)
    CustomerService.createCustomer(customers).then((response) =>{
      console.log(response.data)
      navigate('/customer');

    }).catch(error => {
      console.log(error);
    })

  }

  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2 className="text-center">Add Customer</h2>
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
                  <label className="form-label"> Phone Number :</label>
                  <input
                    type="text"
                    placeholder="Enter Phone Number"
                    name="phone"
                    className="form-control"
                    value={phone}
                    onChange={(e) => setphone(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Street :</label>
                  <input
                    type="text"
                    placeholder="Enter Street"
                    name="Street"
                    className="form-control"
                    value={street}
                    onChange={(e) => setStreet(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> City :</label>
                  <input
                    type="text"
                    placeholder="Enter City"
                    name="City"
                    className="form-control"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> State :</label>
                  <input
                    type="text"
                    placeholder="Enter State"
                    name="State"
                    className="form-control"
                    value={state}
                    onChange={(e) => setState(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Country :</label>
                  <input
                    type="text"
                    placeholder="Enter Country"
                    name="Country"
                    className="form-control"
                    value={country}
                    onChange={(e) => setCountry(e.target.value)}
                  ></input>
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Description :</label>
                  <input
                    type="text"
                    placeholder="Enter Description"
                    name="Description"
                    className="form-control"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                  ></input>
                </div>
                <br></br>
                <button className="btn btn-success" onClick={(e) => saveCustomer(e)}>Submit</button>
                <Link to="/customer" className="btn btn-danger "> Cancel </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddCustomer;
