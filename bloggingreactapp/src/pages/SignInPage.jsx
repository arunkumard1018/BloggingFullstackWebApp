

const SignInPage = () => {
    return (
        <div className="flex items-center justify-center h-screen">
            <div className=" p-8 rounded-lg  w-full max-w-md">
                <h2 className="text-2xl font-semibold mb-6 text-center">Sign In</h2>

                <div className="mb-4">
                    <label htmlFor="username" className="block text-sm font-medium text-gray-600">Username</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your username"
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
                    />
                </div>

                {/* Forgot Password Link */}
                <div className="mb-6 text-right">
                    <a href="/" className="text-blue-500 hover:underline">Forgot Password?</a>
                </div>

                {/* Sign In Button */}
                <button
                    className="w-full bg-blue-500 text-white rounded-md py-2 px-4 hover:bg-blue-600 focus:outline-none"
                    type="button"
                >
                    Sign In
                </button>

                {/* Sign Up Link */}
                <div className="mt-4 text-center">
                    <p className="text-gray-600">Don't have an account? <a href="/" className="text-blue-500 hover:underline">Sign Up</a></p>
                </div>
            </div>
        </div>
    );
};

export default SignInPage;
