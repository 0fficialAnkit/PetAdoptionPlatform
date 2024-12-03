document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const username = document.getElementById("username").value;
    
    // Simulate a login
    if (username === "admin") {
        loadDashboard("Admin");
    } else if (username === "shelter") {
        loadDashboard("Shelter");
    } else if (username === "adopter") {
        loadDashboard("Adopter");
    } else {
        alert("User not found.");
    }
});

function loadDashboard(role) {
    document.querySelector(".login-container").style.display = "none";
    document.getElementById("dashboard").style.display = "block";
    document.getElementById("dashboardTitle").innerText = `${role} Dashboard`;
    
    // Load content based on role
    const content = document.getElementById("dashboardContent");
    if (role === "Admin") {
        content.innerHTML = `
            <p>Manage Users, Pet Listings, and System Settings</p>
            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-success mx-2">Manage Users</button>
                <button class="btn btn-info mx-2">Manage Pet Listings</button>
                <button class="btn btn-warning mx-2">System Settings</button>
            </div>`;
    } else if (role === "Shelter") {
        content.innerHTML = `
            <p>List Pets, Manage Applications, and Communicate with Adopters</p>
            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-success mx-2">List Pets</button>
                <button class="btn btn-info mx-2">Manage Applications</button>
                <button class="btn btn-warning mx-2">Communicate</button>
            </div>`;
    } else if (role === "Adopter") {
        content.innerHTML = `
            <p>Browse Pets, Apply for Adoption, and Track Application Status</p>
            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-success mx-2">Browse Pets</button>
                <button class="btn btn-info mx-2">Apply for Adoption</button>
                <button class="btn btn-warning mx-2">Track Status</button>
            </div>`;
    }
}

function logout() {
    document.querySelector(".login-container").style.display = "block";
    document.getElementById("dashboard").style.display = "none";
}
