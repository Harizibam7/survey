import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Dashboard = () => {
    const [activities, setActivities] = useState([]);

    useEffect(() => {
        // Fetch data from Spring Boot backend
        axios.get('http://localhost:8080/api/users', { withCredentials: true })
            .then(response => {
                if (Array.isArray(response.data)) {
                    setActivities(response.data);
                } else {
                    console.error('Expected an array but got:', response.data);
                }
            })
            .catch(error => {
                console.error('Error fetching activities:', error);
            });
    }, []);
 
    return (
        <div>
            <h2>Dashboard</h2>
            <ul>
                {activities.length > 0 ? (
                    activities.map(user => (
                        <li key={user.id}>{user.username}</li> // Change 'activity.name' to 'user.username'
                    ))
                ) : (
                    <li>No activities found</li>
                )}
            </ul>
        </div>
    );
};

export default Dashboard;
