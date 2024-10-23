import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Logout = () => {
    const navigate = useNavigate();

    useEffect(() => {
        // Clear any authentication tokens, sessions, or user data
        localStorage.removeItem('authToken'); // Example: remove token from localStorage

        // Redirect to the login page
        navigate('/login');
    }, [navigate]);

    return (
        <div>
            <h2>Logging out...</h2>
        </div>
    );
};

export default Logout;
