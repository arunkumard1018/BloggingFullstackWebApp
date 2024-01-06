import React from 'react'
import image from '../assets/images/sample-image.jpg'
function BlogPostContainer() {
    return (
        <div>
            <LandingPage/>
        </div>
    )
}



const LandingPage = () => {
    // Dummy data for the blog posts
    const blogPosts = [
        {
            id: 1,
            author: {
                name: 'John Doe',
                image: 'author1', // replace with the actual path to the author's image
            },
            title: 'Lorem Ipsum Blog',
            image: 'blog1.jpg', // replace with the actual path to the blog image
            subheading: 'A subheading for the blog post',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
            date: 'January 1, 2023',
        },
        {
            id: 1,
            author: {
                name: 'John Doe',
                image: 'author1', // replace with the actual path to the author's image
            },
            title: 'Lorem Ipsum Blog',
            image: 'blog1.jpg', // replace with the actual path to the blog image
            subheading: 'A subheading for the blog post',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
            date: 'January 1, 2023',
        },
        {
            id: 1,
            author: {
                name: 'John Doe',
                image: 'author1', // replace with the actual path to the author's image
            },
            title: 'Lorem Ipsum Blog',
            image: 'blog1.jpg', // replace with the actual path to the blog image
            subheading: 'A subheading for the blog post',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
            date: 'January 1, 2023',
        },
        {
            id: 1,
            author: {
                name: 'John Doe',
                image: 'author1', // replace with the actual path to the author's image
            },
            title: 'Lorem Ipsum Blog',
            image: 'blog1.jpg', // replace with the actual path to the blog image
            subheading: 'A subheading for the blog post',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
            date: 'January 1, 2023',
        },
        {
            id: 1,
            author: {
                name: 'John Doe',
                image: 'author1', // replace with the actual path to the author's image
            },
            title: 'Lorem Ipsum Blog lorem',
            image: 'blog1.jpg', // replace with the actual path to the blog image
            subheading: 'A subheading for the blog post',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
            date: 'January 1, 2023',
        },
        // Add more blog posts as needed
    ];

    return (
        <div className=" min-h-screen mt-[6rem] md:mx-[250px]">

            <main className="container mx-auto">
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
                    {blogPosts.map((post) => (
                        <div key={post.id} className="bg-white p-4 rounded-lg shadow-sm">
                            <div className="mb-4 flex space-x-3">
                                <img src={image} alt={post.author.name} className="w-10 h-10 rounded-full mb-2" />
                                <div><p className="text-gray-600 text-left">{post.author.name}</p>
                                <p className="text-gray-500">{post.id} | {post.date}</p></div>
                            </div>
                            <img src={image} alt={post.title} className="mb-4 rounded-lg md:h-[200px] w-[100%]"  />
                            <h2 className="text-xl font-semibold mb-2">{post.title}</h2>
                            <p className="text-gray-700 mb-2">{post.subheading}</p>
                            <p className="text-gray-800">{post.description}</p>
                        </div>
                    ))}
                </div>
            </main>
        </div>
    );
};


export default BlogPostContainer