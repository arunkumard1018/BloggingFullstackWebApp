import React from 'react'
import image from '../assets/images/sample-image.jpg'
import { blogPosts, findPostById } from '../api/BlogPostServiceApi';
import { Link, useParams } from 'react-router-dom';

function BlogPostPage() {
    return (
        <div>
            <BlogDetailPage />
        </div>
    )
}

const BlogDetailPage = () => {


    // Dummy data for the current blog post
    const { postId } = useParams()
    const currentBlog = findPostById(parseInt(postId))

    const otherBlogs = blogPosts;

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
                    <img src={image} alt={currentBlog.title} className="mb-4 rounded-lg md:h-[300px] md:w-[300px] h-[200px] w-[200px] lg:h-[400px] lg:w-[400px]" />
                    <p className="text-gray-800">{currentBlog.description}</p>
                </div>
                {/* Other Blog Recommendations */}
                <div className="mt-8">
                    <h2 className="text-2xl font-semibold mb-4">Other Blog Recommendations</h2>
                    <div className="grid grid-rows-1 grid-cols-2 md:grid-cols-4  lg:grid-cols-6 gap-2">
                        {otherBlogs.map((blog) => (
                            <OtherPostRecomendetions blog={blog} />
                        ))}
                    </div>
                </div>
            </main>
        </div>
    );
};


export const OtherPostRecomendetions = ({ blog }) => {
    return (
        <Link to={`/posts/${blog.id}`}>
            <div key={blog.id} className="bg-white p-4 rounded-lg flex flex-col justify-center">
                <img src={image} alt={blog.title} className="mb-4 rounded-lg h-[180px] w-[100%]" />
                <h3 className="text-md font-semibold mb-2 ">{blog.title}</h3>
                <p >{blog.subheading}</p>
                {/* You can add more details or links to these recommended blogs */}
            </div>
        </Link>
    )
}


export default BlogPostPage