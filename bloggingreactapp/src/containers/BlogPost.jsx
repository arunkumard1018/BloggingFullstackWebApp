import React from 'react'
import image from '../assets/images/sample-image.jpg'
import { Link } from 'react-router-dom'

function BlogPost({ blogPosts }) {
    return (
        <div>
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
                {blogPosts.map((post) => (
                    <Post post={post} />
                ))}
            </div>
        </div>
    )
}


const Post = ({ post }) => {
    return (
        <Link to={`/posts/${post.id}`} >
            <div key={post.id} className="bg-white p-4 rounded-lg shadow-sm">
                <div className="mb-4 flex space-x-3">
                    <img src={image} alt={post.author.name} className="w-10 h-10 rounded-full mb-2" />
                    <div><p className="text-gray-600 text-left">{post.author.name}</p>
                        <p className="text-gray-500">{post.id} | {post.date}</p></div>
                </div>
                <img src={image} alt={post.title} className="mb-4 rounded-lg h-[300px] md:h-[200px] lg:h-[300px] w-[100%]" />
                <h2 className="text-xl font-semibold mb-2">{post.title}</h2>
                <p className="text-gray-700 mb-2">{post.subheading}</p>
                <p className="text-gray-800">{post.description}</p>
            </div>
        </Link>
    )
}

export default BlogPost