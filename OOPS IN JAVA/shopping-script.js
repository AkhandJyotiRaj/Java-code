// Shopping page JavaScript functionality
document.addEventListener('DOMContentLoaded', function() {
    // Mobile menu toggle
    const mobileMenuBtn = document.querySelector('.mobile-menu-btn');
    const navActions = document.querySelector('.nav-actions');
    
    if (mobileMenuBtn) {
        mobileMenuBtn.addEventListener('click', function() {
            navActions.classList.toggle('active');
        });
    }

    // Search functionality
    const searchInput = document.querySelector('.search-input');
    const searchBtn = document.querySelector('.search-btn');
    
    if (searchBtn) {
        searchBtn.addEventListener('click', function() {
            const searchTerm = searchInput.value.trim();
            if (searchTerm) {
                performSearch(searchTerm);
            }
        });
    }
    
    if (searchInput) {
        searchInput.addEventListener('keypress', function(e) {
            if (e.key === 'Enter') {
                const searchTerm = this.value.trim();
                if (searchTerm) {
                    performSearch(searchTerm);
                }
            }
        });
    }

    // Product interactions
    const productCards = document.querySelectorAll('.product-card');
    productCards.forEach(card => {
        const quickViewBtn = card.querySelector('.quick-view-btn');
        const addToCartBtn = card.querySelector('.add-to-cart-btn');
        
        if (quickViewBtn) {
            quickViewBtn.addEventListener('click', function(e) {
                e.stopPropagation();
                showQuickView(card);
            });
        }
        
        if (addToCartBtn) {
            addToCartBtn.addEventListener('click', function(e) {
                e.stopPropagation();
                addToCart(card);
            });
        }
    });

    // Category cards interaction
    const categoryCards = document.querySelectorAll('.category-card');
    categoryCards.forEach(card => {
        card.addEventListener('click', function() {
            const categoryName = this.querySelector('h3').textContent;
            showCategoryProducts(categoryName);
        });
    });

    // Newsletter subscription
    const newsletterForm = document.querySelector('.newsletter-form');
    if (newsletterForm) {
        newsletterForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const email = this.querySelector('.newsletter-input').value;
            if (validateEmail(email)) {
                subscribeNewsletter(email);
            } else {
                showNotification('Please enter a valid email address', 'error');
            }
        });
    }

    // Nav buttons functionality
    const navBtns = document.querySelectorAll('.nav-btn');
    navBtns.forEach(btn => {
        btn.addEventListener('click', function() {
            const icon = this.querySelector('i');
            if (icon.classList.contains('fa-heart')) {
                showWishlist();
            } else if (icon.classList.contains('fa-shopping-cart')) {
                showCart();
            } else if (icon.classList.contains('fa-user')) {
                showUserMenu();
            }
        });
    });

    // Smooth scrolling for anchor links
    const anchorLinks = document.querySelectorAll('a[href^="#"]');
    anchorLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const targetId = this.getAttribute('href').substring(1);
            const targetElement = document.getElementById(targetId);
            if (targetElement) {
                targetElement.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // Add to cart animation
    function addToCart(productCard) {
        const productName = productCard.querySelector('h3').textContent;
        const productPrice = productCard.querySelector('.current-price').textContent;
        
        // Add animation
        const cartBtn = productCard.querySelector('.add-to-cart-btn');
        cartBtn.style.transform = 'scale(0.95)';
        cartBtn.textContent = 'Added!';
        cartBtn.style.background = '#10b981';
        
        setTimeout(() => {
            cartBtn.style.transform = 'scale(1)';
            cartBtn.textContent = 'Add to Cart';
            cartBtn.style.background = '';
        }, 1000);
        
        // Update cart badge
        updateCartBadge();
        
        // Show notification
        showNotification(`${productName} added to cart!`, 'success');
    }

    // Quick view functionality
    function showQuickView(productCard) {
        const productName = productCard.querySelector('h3').textContent;
        const productPrice = productCard.querySelector('.current-price').textContent;
        const productImage = productCard.querySelector('img').src;
        
        // Create modal
        const modal = document.createElement('div');
        modal.className = 'quick-view-modal';
        modal.innerHTML = `
            <div class="modal-overlay">
                <div class="modal-content">
                    <button class="modal-close">&times;</button>
                    <div class="modal-body">
                        <div class="modal-image">
                            <img src="${productImage}" alt="${productName}">
                        </div>
                        <div class="modal-info">
                            <h3>${productName}</h3>
                            <p class="modal-price">${productPrice}</p>
                            <p class="modal-description">This is a high-quality product with excellent features and great value for money.</p>
                            <div class="modal-actions">
                                <button class="btn-primary add-to-cart-modal">Add to Cart</button>
                                <button class="btn-secondary">View Details</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `;
        
        document.body.appendChild(modal);
        
        // Close modal
        const closeBtn = modal.querySelector('.modal-close');
        const overlay = modal.querySelector('.modal-overlay');
        
        closeBtn.addEventListener('click', () => modal.remove());
        overlay.addEventListener('click', (e) => {
            if (e.target === overlay) modal.remove();
        });
        
        // Add to cart from modal
        const addToCartModal = modal.querySelector('.add-to-cart-modal');
        addToCartModal.addEventListener('click', () => {
            addToCart(productCard);
            modal.remove();
        });
    }

    // Search functionality
    function performSearch(searchTerm) {
        showNotification(`Searching for "${searchTerm}"...`, 'info');
        // Simulate search
        setTimeout(() => {
            showNotification(`Found 15 results for "${searchTerm}"`, 'success');
        }, 1000);
    }

    // Category products
    function showCategoryProducts(categoryName) {
        showNotification(`Loading ${categoryName} products...`, 'info');
        // Simulate category loading
        setTimeout(() => {
            showNotification(`Showing ${categoryName} products`, 'success');
        }, 800);
    }

    // Newsletter subscription
    function subscribeNewsletter(email) {
        showNotification('Subscribing to newsletter...', 'info');
        // Simulate subscription
        setTimeout(() => {
            showNotification('Successfully subscribed to newsletter!', 'success');
            document.querySelector('.newsletter-input').value = '';
        }, 1000);
    }

    // Nav button actions
    function showWishlist() {
        showNotification('Opening wishlist...', 'info');
    }

    function showCart() {
        showNotification('Opening shopping cart...', 'info');
    }

    function showUserMenu() {
        // Redirect to login page
        window.location.href = 'login.html';
    }

    // Update cart badge
    function updateCartBadge() {
        const cartBadge = document.querySelector('.nav-btn .badge');
        if (cartBadge) {
            const currentCount = parseInt(cartBadge.textContent) || 0;
            cartBadge.textContent = currentCount + 1;
        }
    }

    // Email validation
    function validateEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    // Notification system
    function showNotification(message, type = 'info') {
        const notification = document.createElement('div');
        notification.className = `notification notification-${type}`;
        notification.innerHTML = `
            <div class="notification-content">
                <i class="fas fa-${getNotificationIcon(type)}"></i>
                <span>${message}</span>
            </div>
        `;
        
        // Add styles
        notification.style.cssText = `
            position: fixed;
            top: 20px;
            right: 20px;
            background: ${getNotificationColor(type)};
            color: white;
            padding: 16px 20px;
            border-radius: 12px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 10000;
            animation: slideInRight 0.5s ease-out;
            max-width: 300px;
        `;
        
        document.body.appendChild(notification);
        
        // Remove notification after 3 seconds
        setTimeout(() => {
            notification.style.animation = 'slideOutRight 0.5s ease-in';
            setTimeout(() => {
                if (notification.parentNode) {
                    notification.remove();
                }
            }, 500);
        }, 3000);
    }

    function getNotificationIcon(type) {
        const icons = {
            success: 'check-circle',
            error: 'exclamation-circle',
            info: 'info-circle',
            warning: 'exclamation-triangle'
        };
        return icons[type] || 'info-circle';
    }

    function getNotificationColor(type) {
        const colors = {
            success: 'linear-gradient(135deg, #10b981, #059669)',
            error: 'linear-gradient(135deg, #ef4444, #dc2626)',
            info: 'linear-gradient(135deg, #3b82f6, #2563eb)',
            warning: 'linear-gradient(135deg, #f59e0b, #d97706)'
        };
        return colors[type] || colors.info;
    }

    // Add CSS for notifications and modal
    const style = document.createElement('style');
    style.textContent = `
        @keyframes slideInRight {
            from {
                transform: translateX(100%);
                opacity: 0;
            }
            to {
                transform: translateX(0);
                opacity: 1;
            }
        }
        
        @keyframes slideOutRight {
            from {
                transform: translateX(0);
                opacity: 1;
            }
            to {
                transform: translateX(100%);
                opacity: 0;
            }
        }
        
        .notification-content {
            display: flex;
            align-items: center;
            gap: 8px;
            font-weight: 500;
        }
        
        .quick-view-modal {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 10000;
        }
        
        .modal-overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.8);
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        
        .modal-content {
            background: white;
            border-radius: 16px;
            max-width: 600px;
            width: 100%;
            max-height: 80vh;
            overflow-y: auto;
            position: relative;
            animation: modalSlideIn 0.3s ease-out;
        }
        
        @keyframes modalSlideIn {
            from {
                transform: scale(0.9);
                opacity: 0;
            }
            to {
                transform: scale(1);
                opacity: 1;
            }
        }
        
        .modal-close {
            position: absolute;
            top: 15px;
            right: 15px;
            background: none;
            border: none;
            font-size: 24px;
            cursor: pointer;
            color: #6b7280;
            z-index: 1;
        }
        
        .modal-body {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 30px;
            padding: 30px;
        }
        
        .modal-image img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            border-radius: 12px;
        }
        
        .modal-info h3 {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 10px;
            color: #1a1a1a;
        }
        
        .modal-price {
            font-size: 20px;
            font-weight: 700;
            color: #667eea;
            margin-bottom: 15px;
        }
        
        .modal-description {
            color: #6b7280;
            margin-bottom: 20px;
            line-height: 1.6;
        }
        
        .modal-actions {
            display: flex;
            gap: 15px;
        }
        
        @media (max-width: 768px) {
            .modal-body {
                grid-template-columns: 1fr;
                gap: 20px;
            }
            
            .modal-content {
                margin: 20px;
            }
        }
        
        .nav-actions.active {
            display: flex;
            flex-direction: column;
            position: absolute;
            top: 100%;
            left: 0;
            right: 0;
            background: white;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 0 0 12px 12px;
        }
        
        @media (min-width: 769px) {
            .nav-actions.active {
                display: flex;
                flex-direction: row;
                position: static;
                background: none;
                box-shadow: none;
                padding: 0;
            }
        }
        
        /* Filter buttons styles */
        .filter-buttons {
            background: #f8fafc;
            padding: 30px 0;
            margin-bottom: 40px;
        }
        
        .filter-options {
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        
        .filter-btn {
            padding: 10px 20px;
            border: 2px solid #e5e7eb;
            background: white;
            border-radius: 25px;
            cursor: pointer;
            transition: all 0.3s ease;
            font-weight: 500;
        }
        
        .filter-btn:hover {
            border-color: #667eea;
            color: #667eea;
        }
        
        .filter-btn.active {
            background: #667eea;
            border-color: #667eea;
            color: white;
        }
        
        /* Price range styles */
        .price-range-container {
            margin-top: 30px;
            padding: 20px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        
        .range-slider {
            margin-top: 15px;
        }
        
        .range-slider input[type="range"] {
            width: 100%;
            height: 6px;
            border-radius: 3px;
            background: #e5e7eb;
            outline: none;
            -webkit-appearance: none;
        }
        
        .range-slider input[type="range"]::-webkit-slider-thumb {
            -webkit-appearance: none;
            width: 20px;
            height: 20px;
            border-radius: 50%;
            background: #667eea;
            cursor: pointer;
        }
        
        .range-labels {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
            font-weight: 500;
        }
        
        /* Wishlist and compare buttons */
        .wishlist-btn, .compare-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            width: 35px;
            height: 35px;
            border-radius: 50%;
            border: none;
            background: rgba(255, 255, 255, 0.9);
            color: #6b7280;
            cursor: pointer;
            display: flex;
            align-items: center;
            justify-content: center;
            transition: all 0.3s ease;
            z-index: 2;
        }
        
        .compare-btn {
            top: 50px;
        }
        
        .wishlist-btn:hover, .compare-btn:hover {
            background: white;
            color: #667eea;
            transform: scale(1.1);
        }
        
        .wishlist-btn.active {
            color: #ef4444;
        }
        
        .compare-btn.active {
            color: #667eea;
            background: #667eea;
            color: white;
        }
        
        /* Search suggestions */
        .search-suggestions {
            position: absolute;
            top: 100%;
            left: 0;
            right: 0;
            background: white;
            border: 1px solid #e5e7eb;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            z-index: 1000;
            max-height: 200px;
            overflow-y: auto;
        }
        
        .suggestion-item {
            padding: 12px 16px;
            cursor: pointer;
            border-bottom: 1px solid #f3f4f6;
            transition: background 0.2s ease;
        }
        
        .suggestion-item:hover {
            background: #f8fafc;
        }
        
        .suggestion-item:last-child {
            border-bottom: none;
        }
        
        /* Comparison modal */
        .comparison-content {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin: 20px 0;
        }
        
        .comparison-item {
            text-align: center;
            padding: 15px;
            border: 1px solid #e5e7eb;
            border-radius: 8px;
        }
        
        .comparison-item img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 10px;
        }
        
        .comparison-actions {
            display: flex;
            gap: 15px;
            justify-content: center;
            margin-top: 20px;
        }
        
        /* Skip link */
        .skip-link:focus {
            top: 6px !important;
        }
        
        /* Animation keyframes */
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        /* Responsive design */
        @media (max-width: 768px) {
            .filter-options {
                flex-direction: column;
            }
            
            .filter-btn {
                text-align: center;
            }
            
            .comparison-content {
                grid-template-columns: 1fr;
            }
        }
    `;
    document.head.appendChild(style);

    // Add loading states to buttons
    const buttons = document.querySelectorAll('button');
    buttons.forEach(button => {
        button.addEventListener('click', function() {
            if (this.classList.contains('btn-primary') || this.classList.contains('btn-secondary')) {
                this.style.opacity = '0.8';
                this.style.pointerEvents = 'none';
                
                setTimeout(() => {
                    this.style.opacity = '1';
                    this.style.pointerEvents = 'auto';
                }, 1000);
            }
        });
    });

    // Add scroll animations
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
            }
        });
    }, observerOptions);

    // Observe elements for scroll animations
    const animatedElements = document.querySelectorAll('.category-card, .product-card');
    animatedElements.forEach(el => {
        el.style.opacity = '0';
        el.style.transform = 'translateY(20px)';
        el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
        observer.observe(el);
    });

    // Additional enhanced functionality
    initializeProductFilters();
    initializeWishlist();
    initializePriceRange();
    initializeProductComparison();
    initializeLazyLoading();
    initializeKeyboardNavigation();
    initializeAccessibilityFeatures();
});

// Product filtering functionality
function initializeProductFilters() {
    const filterButtons = document.querySelectorAll('.filter-btn');
    const products = document.querySelectorAll('.product-card');
    
    // Add filter buttons if they don't exist
    if (!document.querySelector('.filter-buttons')) {
        const filterContainer = document.createElement('div');
        filterContainer.className = 'filter-buttons';
        filterContainer.innerHTML = `
            <div class="container">
                <h3>Filter Products</h3>
                <div class="filter-options">
                    <button class="filter-btn active" data-filter="all">All Products</button>
                    <button class="filter-btn" data-filter="electronics">Electronics</button>
                    <button class="filter-btn" data-filter="fashion">Fashion</button>
                    <button class="filter-btn" data-filter="sports">Sports</button>
                    <button class="filter-btn" data-filter="books">Books</button>
                </div>
            </div>
        `;
        
        const featuredSection = document.querySelector('.featured-products');
        featuredSection.insertBefore(filterContainer, featuredSection.querySelector('.container'));
    }
    
    // Filter functionality
    document.addEventListener('click', function(e) {
        if (e.target.classList.contains('filter-btn')) {
            const filter = e.target.dataset.filter;
            
            // Update active button
            document.querySelectorAll('.filter-btn').forEach(btn => btn.classList.remove('active'));
            e.target.classList.add('active');
            
            // Filter products
            products.forEach(product => {
                if (filter === 'all' || product.dataset.category === filter) {
                    product.style.display = 'block';
                    product.style.animation = 'fadeInUp 0.5s ease';
                } else {
                    product.style.display = 'none';
                }
            });
            
            showNotification(`Showing ${filter === 'all' ? 'all' : filter} products`, 'info');
        }
    });
}

// Wishlist functionality
function initializeWishlist() {
    let wishlist = JSON.parse(localStorage.getItem('wishlist')) || [];
    
    // Add wishlist button to products
    const productCards = document.querySelectorAll('.product-card');
    productCards.forEach(card => {
        const wishlistBtn = document.createElement('button');
        wishlistBtn.className = 'wishlist-btn';
        wishlistBtn.innerHTML = '<i class="far fa-heart"></i>';
        wishlistBtn.title = 'Add to Wishlist';
        
        const productName = card.querySelector('h3').textContent;
        const isInWishlist = wishlist.some(item => item.name === productName);
        
        if (isInWishlist) {
            wishlistBtn.innerHTML = '<i class="fas fa-heart"></i>';
            wishlistBtn.classList.add('active');
        }
        
        wishlistBtn.addEventListener('click', function(e) {
            e.stopPropagation();
            toggleWishlist(card, wishlistBtn);
        });
        
        card.querySelector('.product-overlay').appendChild(wishlistBtn);
    });
    
    function toggleWishlist(productCard, btn) {
        const productName = productCard.querySelector('h3').textContent;
        const productPrice = productCard.querySelector('.current-price').textContent;
        const productImage = productCard.querySelector('img').src;
        
        const product = {
            name: productName,
            price: productPrice,
            image: productImage,
            id: Date.now()
        };
        
        const existingIndex = wishlist.findIndex(item => item.name === productName);
        
        if (existingIndex > -1) {
            wishlist.splice(existingIndex, 1);
            btn.innerHTML = '<i class="far fa-heart"></i>';
            btn.classList.remove('active');
            showNotification(`${productName} removed from wishlist`, 'info');
        } else {
            wishlist.push(product);
            btn.innerHTML = '<i class="fas fa-heart"></i>';
            btn.classList.add('active');
            showNotification(`${productName} added to wishlist`, 'success');
        }
        
        localStorage.setItem('wishlist', JSON.stringify(wishlist));
        updateWishlistBadge();
    }
    
    function updateWishlistBadge() {
        const wishlistBadge = document.querySelector('.nav-btn .badge');
        if (wishlistBadge) {
            wishlistBadge.textContent = wishlist.length;
        }
    }
    
    updateWishlistBadge();
}

// Price range filter
function initializePriceRange() {
    const priceRangeContainer = document.createElement('div');
    priceRangeContainer.className = 'price-range-container';
    priceRangeContainer.innerHTML = `
        <div class="price-range">
            <h4>Price Range</h4>
            <div class="range-slider">
                <input type="range" id="priceRange" min="0" max="2000" value="2000" step="50">
                <div class="range-labels">
                    <span>$0</span>
                    <span id="currentPrice">$2000</span>
                </div>
            </div>
        </div>
    `;
    
    const filterContainer = document.querySelector('.filter-buttons .container');
    if (filterContainer) {
        filterContainer.appendChild(priceRangeContainer);
    }
    
    const priceRange = document.getElementById('priceRange');
    const currentPrice = document.getElementById('currentPrice');
    
    if (priceRange) {
        priceRange.addEventListener('input', function() {
            const value = this.value;
            currentPrice.textContent = `$${value}`;
            filterByPrice(parseInt(value));
        });
    }
    
    function filterByPrice(maxPrice) {
        const products = document.querySelectorAll('.product-card');
        products.forEach(product => {
            const priceText = product.querySelector('.current-price').textContent;
            const price = parseInt(priceText.replace(/[^0-9]/g, ''));
            
            if (price <= maxPrice) {
                product.style.display = 'block';
            } else {
                product.style.display = 'none';
            }
        });
    }
}

// Product comparison functionality
function initializeProductComparison() {
    let comparisonList = [];
    const maxComparison = 3;
    
    // Add compare button to products
    const productCards = document.querySelectorAll('.product-card');
    productCards.forEach(card => {
        const compareBtn = document.createElement('button');
        compareBtn.className = 'compare-btn';
        compareBtn.innerHTML = '<i class="fas fa-balance-scale"></i>';
        compareBtn.title = 'Add to Compare';
        
        compareBtn.addEventListener('click', function(e) {
            e.stopPropagation();
            addToComparison(card, compareBtn);
        });
        
        card.querySelector('.product-overlay').appendChild(compareBtn);
    });
    
    function addToComparison(productCard, btn) {
        const productName = productCard.querySelector('h3').textContent;
        const productPrice = productCard.querySelector('.current-price').textContent;
        const productImage = productCard.querySelector('img').src;
        
        const product = {
            name: productName,
            price: productPrice,
            image: productImage,
            id: Date.now()
        };
        
        const existingIndex = comparisonList.findIndex(item => item.name === productName);
        
        if (existingIndex > -1) {
            comparisonList.splice(existingIndex, 1);
            btn.classList.remove('active');
            showNotification(`${productName} removed from comparison`, 'info');
        } else {
            if (comparisonList.length >= maxComparison) {
                showNotification(`Maximum ${maxComparison} products can be compared`, 'warning');
                return;
            }
            
            comparisonList.push(product);
            btn.classList.add('active');
            showNotification(`${productName} added to comparison`, 'success');
        }
        
        updateComparisonUI();
    }
    
    function updateComparisonUI() {
        // Create comparison modal if it doesn't exist
        if (!document.querySelector('.comparison-modal')) {
            const modal = document.createElement('div');
            modal.className = 'comparison-modal';
            modal.innerHTML = `
                <div class="modal-overlay">
                    <div class="modal-content">
                        <button class="modal-close">&times;</button>
                        <h3>Product Comparison</h3>
                        <div class="comparison-content"></div>
                        <div class="comparison-actions">
                            <button class="btn-primary" onclick="clearComparison()">Clear All</button>
                            <button class="btn-secondary" onclick="closeComparison()">Close</button>
                        </div>
                    </div>
                </div>
            `;
            document.body.appendChild(modal);
        }
        
        const comparisonContent = document.querySelector('.comparison-content');
        if (comparisonContent) {
            comparisonContent.innerHTML = comparisonList.map(product => `
                <div class="comparison-item">
                    <img src="${product.image}" alt="${product.name}">
                    <h4>${product.name}</h4>
                    <p>${product.price}</p>
                </div>
            `).join('');
        }
    }
    
    // Global functions for comparison
    window.clearComparison = function() {
        comparisonList = [];
        document.querySelectorAll('.compare-btn').forEach(btn => btn.classList.remove('active'));
        showNotification('Comparison cleared', 'info');
    };
    
    window.closeComparison = function() {
        document.querySelector('.comparison-modal').remove();
    };
}

// Lazy loading for images
function initializeLazyLoading() {
    const images = document.querySelectorAll('img');
    
    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.dataset.src || img.src;
                img.classList.remove('lazy');
                observer.unobserve(img);
            }
        });
    });
    
    images.forEach(img => {
        img.classList.add('lazy');
        imageObserver.observe(img);
    });
}

// Keyboard navigation
function initializeKeyboardNavigation() {
    document.addEventListener('keydown', function(e) {
        // ESC key to close modals
        if (e.key === 'Escape') {
            const modals = document.querySelectorAll('.quick-view-modal, .comparison-modal');
            modals.forEach(modal => modal.remove());
        }
        
        // Enter key on search
        if (e.key === 'Enter' && e.target.classList.contains('search-input')) {
            const searchTerm = e.target.value.trim();
            if (searchTerm) {
                performSearch(searchTerm);
            }
        }
        
        // Arrow keys for product navigation
        if (e.key === 'ArrowLeft' || e.key === 'ArrowRight') {
            const focusedProduct = document.querySelector('.product-card:focus');
            if (focusedProduct) {
                const products = Array.from(document.querySelectorAll('.product-card'));
                const currentIndex = products.indexOf(focusedProduct);
                let nextIndex;
                
                if (e.key === 'ArrowLeft') {
                    nextIndex = currentIndex > 0 ? currentIndex - 1 : products.length - 1;
                } else {
                    nextIndex = currentIndex < products.length - 1 ? currentIndex + 1 : 0;
                }
                
                products[nextIndex].focus();
            }
        }
    });
}

// Accessibility features
function initializeAccessibilityFeatures() {
    // Add ARIA labels and roles
    const productCards = document.querySelectorAll('.product-card');
    productCards.forEach((card, index) => {
        card.setAttribute('role', 'button');
        card.setAttribute('tabindex', '0');
        card.setAttribute('aria-label', `Product ${index + 1}: ${card.querySelector('h3').textContent}`);
        
        card.addEventListener('keydown', function(e) {
            if (e.key === 'Enter' || e.key === ' ') {
                e.preventDefault();
                const quickViewBtn = card.querySelector('.quick-view-btn');
                if (quickViewBtn) {
                    quickViewBtn.click();
                }
            }
        });
    });
    
    // Add skip links
    const skipLink = document.createElement('a');
    skipLink.href = '#main-content';
    skipLink.textContent = 'Skip to main content';
    skipLink.className = 'skip-link';
    skipLink.style.cssText = `
        position: absolute;
        top: -40px;
        left: 6px;
        background: #000;
        color: white;
        padding: 8px;
        text-decoration: none;
        z-index: 1000;
    `;
    
    skipLink.addEventListener('focus', function() {
        this.style.top = '6px';
    });
    
    skipLink.addEventListener('blur', function() {
        this.style.top = '-40px';
    });
    
    document.body.insertBefore(skipLink, document.body.firstChild);
    
    // Add main content ID
    const mainContent = document.querySelector('.featured-products');
    if (mainContent) {
        mainContent.id = 'main-content';
    }
}

// Enhanced search with suggestions
function initializeSearchSuggestions() {
    const searchInput = document.querySelector('.search-input');
    if (!searchInput) return;
    
    const suggestions = [
        'Wireless Headphones',
        'Smart Watch',
        'Running Shoes',
        'Gaming Laptop',
        'Fashion',
        'Electronics',
        'Sports',
        'Books'
    ];
    
    const suggestionsContainer = document.createElement('div');
    suggestionsContainer.className = 'search-suggestions';
    suggestionsContainer.style.cssText = `
        position: absolute;
        top: 100%;
        left: 0;
        right: 0;
        background: white;
        border: 1px solid #e5e7eb;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        z-index: 1000;
        display: none;
    `;
    
    const searchContainer = document.querySelector('.search-container');
    if (searchContainer) {
        searchContainer.style.position = 'relative';
        searchContainer.appendChild(suggestionsContainer);
    }
    
    searchInput.addEventListener('input', function() {
        const value = this.value.toLowerCase();
        if (value.length > 0) {
            const filteredSuggestions = suggestions.filter(suggestion => 
                suggestion.toLowerCase().includes(value)
            );
            
            if (filteredSuggestions.length > 0) {
                suggestionsContainer.innerHTML = filteredSuggestions.map(suggestion => 
                    `<div class="suggestion-item">${suggestion}</div>`
                ).join('');
                suggestionsContainer.style.display = 'block';
            } else {
                suggestionsContainer.style.display = 'none';
            }
        } else {
            suggestionsContainer.style.display = 'none';
        }
    });
    
    suggestionsContainer.addEventListener('click', function(e) {
        if (e.target.classList.contains('suggestion-item')) {
            searchInput.value = e.target.textContent;
            suggestionsContainer.style.display = 'none';
            performSearch(e.target.textContent);
        }
    });
    
    // Hide suggestions when clicking outside
    document.addEventListener('click', function(e) {
        if (!searchContainer.contains(e.target)) {
            suggestionsContainer.style.display = 'none';
        }
    });
}

// Initialize search suggestions
initializeSearchSuggestions();
