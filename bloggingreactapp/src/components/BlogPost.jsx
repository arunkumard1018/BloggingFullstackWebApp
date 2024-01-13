import React, { useState } from 'react';
function BlogPost() {
    return (
        <div className='md:mx-[250px]'>
            <NewBlogForm />
        </div>
    )
}


const NewBlogForm = () => {
    const [blogData, setBlogData] = useState({
        title: '',
        subheading: '',
        description: '',
        date: '',
    });

    const [imageFile, setImageFile] = useState(null);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setBlogData({
            ...blogData,
            [name]: value,
        });
    };

    const handleImageChange = (e) => {
        const file = e.target.files[0];
        setImageFile(file);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Blog data submitted:', blogData);
        console.log('Image file:', imageFile);
        setBlogData({
            title: '',
            subheading: '',
            description: '',
            date: '',
        });
        setImageFile(null);
    };

    return (
        <div className="mt-[4rem] flex items-center justify-center">
            <div className="bg-white p-8 rounded w-[80vw]">
                <h2 className="text-2xl font-semibold mb-4">Create a New Blog</h2>
                <form onSubmit={handleSubmit}>
                    <div className="mb-4">
                        <label htmlFor="title" className="block text-sm font-medium text-gray-600">
                            Title:
                        </label>
                        <input
                            type="text"
                            id="title"
                            name="title"
                            value={blogData.title}
                            onChange={handleInputChange}
                            className="mt-1 p-2 w-full border rounded-md"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="subheading" className=" text-sm font-medium text-gray-600">
                            Subheading:
                        </label>
                        <input
                            type="text"
                            id="subheading"
                            name="subheading"
                            value={blogData.subheading}
                            onChange={handleInputChange}
                            className="mt-1 p-2 w-full border rounded-md"
                            required
                        />
                    </div>

                    <div className="mb-4">
                        <label htmlFor="description" className="block text-sm font-medium text-gray-600">
                            Description:
                        </label>
                        <textarea
                            id="description"
                            name="description"
                            value={blogData.description}
                            onChange={handleInputChange}
                            className="mt-1 p-2 w-full border rounded-md h-[25vh]"
                            required
                        ></textarea>
                    </div>
{/* 
                    <div className="mb-4">
                        <label htmlFor="date" className="block text-sm font-medium text-gray-600">
                            Date:
                        </label>
                        <input
                            type="text"
                            id="date"
                            name="date"
                            value={blogData.date}
                            onChange={handleInputChange}
                            className="mt-1 p-2 w-full border rounded-md"
                            required
                        />
                    </div> */}

                    <div className="mb-4">
                        <label htmlFor="image" className="block text-sm font-medium text-gray-600">
                            Blog Image:
                        </label>
                        <input
                            type="file"
                            id="image"
                            accept="image/*"
                            onChange={handleImageChange}
                            className="mt-1 p-2 w-full border rounded-md"
                        />
                    </div>

                    <button
                        type="submit"
                        className="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 focus:outline-none focus:ring focus:border-blue-300"
                    >
                        Submit
                    </button>
                </form>
            </div>
        </div>
    );
};




export default BlogPost