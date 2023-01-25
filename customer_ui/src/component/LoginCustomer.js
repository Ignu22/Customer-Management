import React from 'react'

const LoginCustomer = () => {
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
                           // value={name}
                            //onChange={(e) => setName(e.target.value)}
                        ></input>
                    </div>
                    <div className="form-group mb-2">
                    <label className="form-label"> Password :</label>
                        <input
                            type="text"
                            placeholder="Enter Password"
                            name="Name"
                            className="form-control"
                           // value={name}
                            //onChange={(e) => setName(e.target.value)}
                        ></input>
                    </div>
                    <button className="btn btn-success" /*</form>onClick={(e) => saveCustomer(e)}*/>Login</button>
                </form>
            </div>
          </div>
        </div>
    </div>
    </div>
  )
}

export default LoginCustomer