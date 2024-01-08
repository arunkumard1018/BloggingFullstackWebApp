
export const blogPosts = [
    {
        id: 111,
        author: {
            name: 'John Doe',
            image: 'author1', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog 111',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    },
    {
        id: 112,
        author: {
            name: 'John Doe',
            image: 'author1', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog 112',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    },
    {
        id: 113,
        author: {
            name: 'John Doe',
            image: 'author1', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog 113',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    },
    {
        id: 115,
        author: {
            name: 'John Doe',
            image: 'author1', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog 115',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    },
    {
        id: 116,
        author: {
            name: 'John Doe',
            image: 'author1', // replace with the actual path to the author's image
        },
        title: 'Lorem Ipsum Blog lorem 116',
        image: 'blog1.jpg', // replace with the actual path to the blog image
        subheading: 'A subheading for the blog post',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Duis sagittis mi sit amet magna cursus, id auctor lectus interdum.',
        date: 'January 1, 2023',
    },
    // Add more blog posts as needed
];

export const findPostById = (postId) => {
    const foundPost = blogPosts.find((post) => post.id === postId);
    return foundPost;
};
