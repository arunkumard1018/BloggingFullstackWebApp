

const RegistrationPage = () => {
    return (
        <div className="flex items-center justify-center mt-20 md:mt-9 md:h-screen">
            <div className="bg-white p-8 rounded-lg shadow-sm w-full max-w-md">
                <h2 className="text-2xl font-semibold mb-6 text-center">Sign Up</h2>

                {/* Name Field */}
                <div className="mb-4">
                    <label htmlFor="name" className="block text-sm font-medium text-gray-600">Name</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your name"
                    />
                </div>

                {/* Email Field */}
                <div className="mb-4">
                    <label htmlFor="email" className="block text-sm font-medium text-gray-600">Email</label>
                    <input
                        type="email"
                        id="email"
                        name="email"
                        className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                        placeholder="Enter your email"
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

                {/* Date of Birth (DOB) Field */}
                <div className="mb-4">
                    <label htmlFor="dob" className="block text-sm font-medium text-gray-600">Date of Birth</label>
                    <input
                        type="date"
                        id="dob"
                        name="dob"
                        className="w-full border rounded-md py-2 px-3 focus:outline-none focus:border-blue-500"
                    />
                </div>

                {/* Sign Up with Social Media Buttons */}
                <div className="mb-4">
                    <p className="text-gray-600 text-center mb-2">Sign up with:</p>
                    <div className="flex justify-center space-x-4">
                        <button className="bg-blue-500 text-white rounded-md py-2 px-4 hover:bg-blue-600 focus:outline-none">
                            Google
                        </button>
                        <button className="bg-blue-700 text-white rounded-md py-2 px-4 hover:bg-blue-800 focus:outline-none">
                            Facebook
                        </button>
                        <button className="bg-blue-400 text-white rounded-md py-2 px-4 hover:bg-blue-500 focus:outline-none">
                            Twitter
                        </button>
                    </div>
                </div>

                {/* Sign Up Button */}
                <button
                    className="w-full bg-blue-500 text-white rounded-md py-2 px-4 hover:bg-blue-600 focus:outline-none"
                    type="button"
                >
                    Sign Up
                </button>

                {/* Sign In Link */}
                <div className="mt-4 text-center">
                    <p className="text-gray-600">Already have an account? <a href="/" className="text-blue-500 hover:underline">Sign In</a></p>
                </div>
            </div>
        </div>
    );
};

export default RegistrationPage;
