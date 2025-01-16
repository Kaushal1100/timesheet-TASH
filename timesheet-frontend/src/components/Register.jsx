import {useState} from 'react'
import axios from 'axios';
function Register(){
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    async function handleSubmit(e){
        e.preventDefault();
        try{
            const response=await axios.post('http://localhost:8082/register',{
                username,password});
        console.log("Registration Successfull:",response.data);
        }catch(error){
            setErrorMessage('Failed To register');
            console.error('Error in registration',error);
        };
    }
    return(
        <div className="register-container">
            <h2>Please Register and Sign up</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Username" value={username}
                onChange={(e)=>setUsername(e.target.value)} required />
                <input type="password" placeholder="Password" value={password}
                onChange={(e)=>setPassword(e.target.value)} required />
                <button type="submit">Register</button>
            </form>
            {errorMessage && <p> {errorMessage}</p>}
        </div>
    );
}
export default Register;