import React from 'react'
import image from '../assets/images/sample-image.jpg'

function BlogPostPage() {
    return (
        <div>
            <BlogDetailPage />
        </div>
    )
}

const BlogDetailPage = () => {
    // Dummy data for the current blog post
    const currentBlog = {
        id: 1,
        author: {
            name: 'John Doe',
            image: 'author1.jpg', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    };

    // Dummy data for other blog recommendations
    const otherBlogs = [
        {
            id: 2,
            title: 'Another Blog Title',
            image: 'blog2.jpg', // replace with the actual path to the blog image
        },
        {
            id: 3,
            title: 'Yet Another Blog',
            image: 'blog3.jpg', // replace with the actual path to the blog image
        },
        // Add more recommended blogs as needed
    ];

    return (
        <div className="mt-[4rem] md:mx-[250px] mx-4">
            <header className=" text-white py-8">
                <div className="container mx-auto">
                    <h1 className="text-4xl font-semibold text-black">{currentBlog.title}</h1>
                    <p className="mt-2 text-black">{currentBlog.subheading}</p>

                    <div className="mt-4 flex items-center">
                        <img src={image} alt={currentBlog.author.name} className="w-8 h-8 rounded-full mr-2" />
                        <div><p className="text-gray-300">{currentBlog.author.name}</p>
                            <p className="text-gray-500">{currentBlog.id} | {currentBlog.date}</p></div>
                    </div>

                </div>
            </header>

            <main className="mx-auto">
                <div className="bg-white  rounded-lg">
                    <img src={image} alt={currentBlog.title} className="mb-4 rounded-lg md:h-[300px] md:w-[300px] h-[200px] w-[200px]" />
                    <p className="text-gray-800">{currentBlog.description}</p>
                </div>



                {/* Other Blog Recommendations */}
                <div className="mt-8">
                    <h2 className="text-2xl font-semibold mb-4">Other Blog Recommendations</h2>
                    <div className="grid grid-cols-2 md:grid-cols-2 lg:grid-cols-3 gap-8">
                        {otherBlogs.map((blog) => (
                            <div key={blog.id} className="bg-white p-4 rounded-lg ">
                                <img src={image} alt={blog.title} className="mb-4 rounded-lg h-[200px]" />
                                <h3 className="text-lg font-semibold mb-2">{blog.title}</h3>
                                {/* You can add more details or links to these recommended blogs */}
                            </div>
                        ))}
                    </div>
                </div>
            </main>
        </div>
    );
};



export default BlogPostPage