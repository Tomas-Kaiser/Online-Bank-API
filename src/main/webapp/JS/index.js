/* 
 * Copyright 2020, Tomas.
 */
function verifyCustomerCredentials(){
    const url = "http://localhost:49000/api/customers";
    
    fetch(url)
        .then(res => res.json())
        .then(jsonRes => console.log(jsonRes))
        .catch(err => console.log('Some error happen', err))

}


