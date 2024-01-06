import React from 'react'

export default function FooterComponent() {
    return (
        <div>
            <Footer />
        </div>
    )
}

const Footer = () => {
    const handleSubscribe = (e) => {
        e.preventDefault();
        // Implement your subscribe logic here
        console.log('Subscribed!');
    };

    return (
        <footer className="bg-gray-800 text-white  absolute w-[100%] bottom-0 pt-3">
            <div className="container mx-auto flex flex-col items-center">

                <div className="mb-4">
                    <a href="/" className="text-gray-300 hover:text-white mr-4">
                        <span className="fab fa-twitter"> twitter</span>
                    </a>
                    <a href="/" className="text-gray-300 hover:text-white mr-4">
                        <span className="fab fa-facebook">facebook</span>
                    </a>
                    <a href="/" className="text-gray-300 hover:text-white">
                        <span className="fab fa-instagram">instagram</span>
                    </a>
                </div>

                <form onSubmit={handleSubscribe} className="mb-4">
                    <label htmlFor="email" className="sr-only">Subscribe to our newsletter</label>
                    <div className="flex items-center">
                        <input
                            type="email"
                            id="email"
                            placeholder="Enter your email"
                            className="bg-gray-700 text-white px-4 py-2 rounded-l-md focus:outline-none"
                        />
                        <button
                            type="submit"
                            className="bg-blue-500 text-white px-4 py-2 rounded-r-md hover:bg-blue-600 focus:outline-none"
                        >
                            Subscribe
                        </button>
                    </div>
                </form>

                {/* Footer Content */}
                <div className="text-center">
                    <p className="text-sm text-gray-500 mb-2">Connect with us on social media for updates</p>
                    <p className="text-sm text-gray-500">&copy; 2023 Your Blog. All rights reserved.</p>
                </div>
            </div>
        </footer>
    );
};



