import {useState} from 'react';
import axios from "axios";
import "../styles/timesheetForm.css";
function Timesheet(){
    
    const [formData,setFormData]=useState({
        employeeId:"",
        projectName:"",
        mondayHours:"",
        tuesdayHours:"",
        wednesdayHours:"",
        thursdayHours:"",
        fridayHours:"",
        saturdayHours:"",
        sundayHours:"",
        hourlyRate:""
    });

    const[message,setMessage]=useState("");
    function handleChange(e){
        const{name,value}=e.target;
        setFormData({...formData,[name]:value});
    }

    async function handleSubmit(e){
        e.preventDefault;
        try{
            const response=await axios.post("http://localhost:8082/timesheet",formData);
            setMessage(response.data);
            setFormData({ employeeId: "",
                projectName: "",
                mondayHours: "",
                tuesdayHours: "",
                wednesdayHours: "",
                thursdayHours: "",
                fridayHours: "",
                saturdayHours: "",
                sundayHours: "",
                hourlyRate: ""
            });
        } catch(err){
            setMessage("Error:"+err.response.data);
        };
    };
return(

    <div className='timesheet-form'>
        <h2> Submit TimeSheet </h2>
        {message && <p className="message">{message}</p>}
        <form onSubmit={handleSubmit}>
            <label>
                EmployeeId:
                <input type="number" name="employeeId" value={formData.employeeId}  
                 onChange={handleChange} required/>
                Project Name:
                <input type="text" name="projectName" value={formData.projectName} 
                onChange={handleChange} required/>
                Monday:
                <input type="number" name="mondayHours" value={formData.mondayHours} min="0"
                onChange={handleChange} required/>
                 Tuesday:
                <input type="number" name="tuesdayHours" value={formData.tuesdayHours} min="0"
                onChange={handleChange} required/>
                 Wednesday:
                <input type="number" name="wednesdayHours" value={formData.wednesdayHours} min="0"
                onChange={handleChange} required/>
                 Thursday:
                <input type="number" name="thursdayHours" value={formData.thursdayHours} min="0"
                onChange={handleChange} required/>
                 Friday:
                <input type="number" name="fridayHours" value={formData.fridayHours} min="0"
                onChange={handleChange} required/>
                Saturday:
                <input type="number" name="saturdayHours" value={formData.saturdayHours} min="0"
                onChange={handleChange} required/>
                 Sunday:
                <input type="number" name="sundayHours" value={formData.sundayHours} min="0"
                onChange={handleChange} required/>
                Hourly:
                <input type="number" name="hourlyRate" value={formData.hourlyRate} min="0"
                onChange={handleChange} required/>

                <button type="submit">Submit</button>
            </label>
        </form>
    </div>
);

};
export default Timesheet;