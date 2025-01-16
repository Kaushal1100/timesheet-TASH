import {useState} from "react";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
const Login=() =>{
    const [username,setUsername]=useState('');
    const [password,setPassword]=useState('');
    const [error,setErrorMessage]=useState('');
    const navigate=useNavigate();
    async function handleLogin(e){
        e.preventDefault();

        try{
            const response=await axios.post('http://localhost:8082/login',{
            username,password,
        });
            if(response.data){
            navigate('/dashboard');
            } 
        }catch(error){
            setErrorMessage('Invalid credentials. Please try again.');
            console.error('Error during login:', error);
          
        }
    };
    return(
        <div style={{ maxWidth: "400px", margin: "50px auto", textAlign: "center" }}>
            <h3 className="welcome-header">Welcome to Time and Space Hub</h3>
             <h5>Please Login to your Employee account</h5>
             {error && <p style={{color:'red'}}>{error}</p>}
             <form onSubmit={handleLogin}>
                <div style={{marginBottom: "10px"}}>
                <input type="text" placeholder="Username" 
                  value={username} onChange={(e) => setUsername(e.target.value)}
                  style={{width: "100%", padding: "10px" }}/>
                </div>
                <div style={{ marginBottom: "10px" }}>
                <input type="password" placeholder="Password"
                value={password} onChange={(e)=> setPassword(e.target.value)}
                style={{width: "100%", padding: "10px" }}/>
                </div>
                <button type="Submit" style={{ width: "100%", padding: "10px" }}>
                Login</button>
             </form>
        </div>      
    );
};
export default Login;