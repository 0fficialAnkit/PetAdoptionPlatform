document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const username = document.getElementById("username").value;
    
    // Simulate a login
    if (username === "admin" || username === "shelter" || username === "adopter") {
        loadPetSelectionPage();
    } else {
        alert("User not found.");
    }
});

function loadPetSelectionPage() {
    document.getElementById("loginPage").style.display = "none";
    document.getElementById("petSelectionPage").style.display = "block";
}

function showAvailablePets() {
    // Get the selected options
    const type = document.getElementById("petType").value;
    const gender = document.getElementById("petGender").value;
    const color = document.getElementById("petColor").value;
    const breed = document.getElementById("petBreed").value;
    const age = document.getElementById("petAge").value;
    const vaccinated = document.getElementById("vaccinated").checked;

    // Simulate available pets based on filters
    const pets = [
        { name: 'Max', type: 'Dog', gender: 'Male', color: 'Brown', breed: 'Labrador', age: 'Puppy', vaccinated: true },
        { name: 'Bella', type: 'Cat', gender: 'Female', color: 'Black', breed: 'Persian', age: 'Adult', vaccinated: false },
        { name: 'Charlie', type: 'Dog', gender: 'Male', color: 'Golden', breed: 'Beagle', age: 'Adult', vaccinated: true }
    ];

    // Filter pets based on selected criteria
    const filteredPets = pets.filter(pet => {
        return (!type || pet.type === type) &&
               (!gender || pet.gender === gender) &&
               (!color || pet.color === color) &&
               (!breed || pet.breed === breed) &&
               (!age || pet.age === age) &&
               (!vaccinated || pet.vaccinated === vaccinated);
    });

    displayPets(filteredPets);
}

function displayPets(pets) {
    const petList = document.getElementById("petList");
    petList.innerHTML = ''; // Clear previous results

    if (pets.length === 0) {
        petList.innerHTML = '<p>No pets available based on the selected criteria.</p>';
    } else {
        pets.forEach(pet => {
            const petCard = `
                <div class="card m-2" style="width: 18rem;">
                    <img src="https://via.placeholder.com/150?text=${pet.name}" class="card-img-top" alt="${pet.name}">
                    <div class="card-body">
                        <h5 class="card-title">${pet.name}</h5>
                        <p class="card-text">Type: ${pet.type}<br>Gender: ${pet.gender}<br>Color: ${pet.color}<br>Breed: ${pet.breed}<br>Age: ${pet.age}<br>Vaccinated: ${pet.vaccinated ? 'Yes' : 'No'}</p>
                    </div>
                </div>
            `;
            petList.innerHTML += petCard;
        });
    }
    document.getElementById("availablePets").style.display = "block";
}

function logout() {
    document.getElementById("loginPage").style.display = "block";
    document.getElementById("petSelectionPage").style.display = "none";
}
