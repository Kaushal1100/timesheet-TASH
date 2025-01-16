import React ,{useState} from "react";
function AddEmployee(){
    const[employee, setEmployee]=useState({
                                        employeeName:"",
                                        phone:"",
                                        email:"",
                                        address:""});
    const [message, setMessage] = useState("");

    function handleChange(e){
        const { name, value } = e.target;
        setEmployee((prev) => ({ ...prev, [name]: value }));
    };

  async function handleSubmit(e){
    e.preventDefault();
    try{
        const response= await fetch("http://localhost:8082/employee",{
            method:"POST",
            headers:{
                "Content-Type":"application/json",
            },
            body:JSON.stringify(employee),
        });
        if(response.ok){
        setMessage("Employee added successfully");
        setEmployee({
            employeeName: "",
            phone: "",
            email: "",
            address: "",
        });
        } else{
            setMessage("Failed to add employee. Please try again.");
        }
    } catch (error) {
            setMessage("An error occurred. Please try again.");
            console.error(error);
        }
  };
    return(
    <div style={{padding:"20px"}}>
        <h2>Add Employee</h2>
        {message && <p>{message}</p>}
            <form onSubmit={handleSubmit}>
               <div style={{ marginBottom: "10px" }}>
                <label>Employee Name:</label>
                <input type="text" name="employeeName"value={employee.employeeName}
                 onChange={handleChange} required/>
                </div>
                <div style={{ marginBottom: "10px" }}>
                 <label>Phone:</label>
                 <input type="text" name="phone" value={employee.phone} onChange={handleChange} required/>
                </div>
                <div style={{ marginBottom: "10px" }}>
                <label>Email:</label>
                <input type="email" name="email" value={employee.email} onChange={handleChange}
                    required/>
                </div>
                <div style={{ marginBottom: "10px" }}>
                <label>Address:</label>
                <input type="text" name="address" value={employee.address} onChange={handleChange} required
                />
            </div>
            <button type="submit">Add Employee</button>
            </form>
     </div>
    );
};
export default AddEmployee;