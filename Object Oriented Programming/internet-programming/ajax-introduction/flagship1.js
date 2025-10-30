let cart = [];

// Book data
const books = [
    {
        id: 1,
        title: "The Silent Patient",
        author: "Alex Michaelides",
        price: 14.99,
        rating: 4.2,
        image: "https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=300&h=400&fit=crop"
    }
    // Add more books here as needed
];

// Initialize cart functionality
function initCart() {
    // Add click event to all cart buttons
    document.querySelectorAll('.btn-outline-primary').forEach(btn => {
        btn.addEventListener('click', function(e) {
            e.preventDefault();
            const card = this.closest('.card');
            addToCart(card);
        });
    });
}