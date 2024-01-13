import React from 'react'
import BlogPostList from './BlogPostList';
import { blogPosts } from '../api/BlogPostServiceApi';

function BlogPostContainer() {

    return (
        <div className=" min-h-screen mt-[6rem] md:mx-[230px] ">
            <main className="container mx-auto">
                <BlogPostList blogPosts={blogPosts} />
            </main>
        </div>
    )
}



export default BlogPostContainer