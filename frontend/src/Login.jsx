import React from 'react';

const Login = () => {
    const handleLogin = () => {
        // Redirect to Spring Boot's OAuth2 login endpoint
        window.location.href = 'http://localhost:8080/oauth2/authorization/google';
    };

    return (
        <div>
            <h2>Login with Google</h2>
            <button onClick={handleLogin}>Login with Google</button>
        </div>
    );
};

export default Login;
