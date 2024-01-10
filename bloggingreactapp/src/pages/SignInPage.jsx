import { useState } from "react";
import { Link, useNavigate} from "react-router-dom";
import { useAuth } from "../security/AuthContext";


const SignInPage = () => {

    const authContext = useAuth();
    const navigate = useNavigate();
    const [showErrorMessage, setshowErrorMessage] = useState(false)

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if(authContext.authenticate(formData)){
            navigate('/')
        }else{
            setshowErrorMessage(true);
        }
    };


    return (
        <div className="flex items-center justify-center h-screen">
            <div className=" p-8 rounded-lg  w-full max-w-md">
                <h2 className="text-2xl font-semibold mb-2 text-center">Sign In</h2>
                {showErrorMessage && <p className="text-sm mb-1 text-center text-red-500">Authentication Failed <br/>Please Check your credentials!</p>}
                <form onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label htmlFor="username" className="block text-sm font-medium text-gray-600">Username</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                            placeholder="Enter your username"
                            value={formData.username}
                            onChange={handleInputChange}
                        />
                    </div>

                    {/* Password Field */}
                    <div className="mb-4">
                        <label htmlFor="password" className="block text-sm font-medium text-gray-600">Password</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                            placeholder="Enter your password"
                            value={formData.password}
                            onChange={handleInputChange}
                        />
                    </div>

                    {/* Forgot Password Link */}
                    <div className="mb-6 text-right">
                        <Link to="/" className="text-blue-500 hover:underline">Forgot Password?</Link>
                    </div>

                    {/* Sign In Button */}
                    <button
                        className="w-full bg-blue-500 text-white rounded-md py-2 px-4 hover:bg-blue-600 focus:outline-none"
                        type="submit"
                    >
                        Sign In
                    </button>
                </form>
                {/* Sign Up Link */}
                <div className="mt-4 text-center">
                    <p className="text-gray-600">Don't have an account? <Link to="/" className="text-blue-500 hover:underline">Sign Up</Link></p>
                </div>
            </div>
        </div>
    );
};

export default SignInPage;
