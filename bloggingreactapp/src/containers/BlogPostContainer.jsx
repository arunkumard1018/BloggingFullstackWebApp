import React, { useState } from 'react'
import BlogPost from './BlogPost';
import { blogPosts } from '../api/BlogPostServiceApi';

function BlogPostContainer() {

    return (
        <div className=" min-h-screen mt-[6rem] md:mx-[250px] ">
            <main className="container mx-auto">
                <BlogPost blogPosts={blogPosts} />
            </main>
        </div>
    )
}



export default BlogPostContainer