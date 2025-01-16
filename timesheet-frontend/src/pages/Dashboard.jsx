
import axios from "axios";
import "../styles/dashboard.css"

import { useState,useEffect } from "react";
function Dashboard(){
    const [timesheets,setTimesheets]=useState([]);
    const[loading,setLoading]=useState(true);
    const[error,setError]=useState(null);

    useEffect(() => {
        const fetchTimesheets = async () => {
           try {
                // Send a GET request
                const response = await axios.get("http://localhost:8082/alltimesheet");
                setTimesheets(response.data); 
                setLoading(false); 
              } catch (err) {
                console.error("Error fetching timesheets:", err);
                setError("Failed to fetch timesheets."); 
                setLoading(false); 
              }
            };
        
            fetchTimesheets();
          }, []);
    if(loading) {
        return <p> Loading timesheets... </p>
    }

    if(error){
        return <p>{error}</p>;
    }
    return(
        <div className="dashboard">
            <h2>Dashboard</h2>
            <p> <marquee style={{ color:'red'}}>Welcome to the Timesheet Dashboard</marquee></p>
            <table className="timesheet-table">
                <thead>
                    <tr>
                        <th>ID </th>
                        <th>Employee Name</th>
                        <th>Project Name</th>
                        <th>Hours</th>
                        <th>Total Pay</th> 
                    </tr>
                </thead>
                <tbody>
                    {timesheets.map((timesheet) =>(
                        <tr key={timesheet.id}>
                            {/* //these should match with the JSON Responsenames */}
                            <td>{timesheet.id}</td>
                            <td>{timesheet.employeeName}</td>
                            <td>{timesheet.projectName}</td>
                            <td>{timesheet.totalHours}</td>
                            <td>{timesheet.totalPay}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default Dashboard;