import { createContext, useContext, useState } from "react";
import { Router, Routes, useNavigate } from "react-router-dom";

export const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

export default function AuthProvider( {children} ){

    const [isAuthenticated, setisAuthenticated] = useState(false);

    const authenticate = (userCredintials) => {
        if(userCredintials.username === 'admin' & userCredintials.password === "dummy"){
            setisAuthenticated(true);
            return true;
        }else{
            setisAuthenticated(false);
            return false;
        }
    }

    const logout = () =>{
        setisAuthenticated(false)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, authenticate, logout} }>
            {children}
        </AuthContext.Provider>
    )
}