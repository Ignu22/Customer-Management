import axios from "axios";

const CUSTOMER_BASE_API_URL="http://localhost:8080/customer";

class CustomerService{

    getAllCustomer(){
        return axios.get(CUSTOMER_BASE_API_URL+"/getAll");
    }

    createCustomer(customers){
        return axios.post(CUSTOMER_BASE_API_URL+"/add",customers);
    }

    loginCustomer(login){
        return axios.post(CUSTOMER_BASE_API_URL+"/login",login);
    }

    signupCustomer(signup){
        return axios.post(CUSTOMER_BASE_API_URL+"/signup",signup)
    }
}

export default new CustomerService();