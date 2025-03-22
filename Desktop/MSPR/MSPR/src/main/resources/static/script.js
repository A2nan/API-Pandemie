const API_BASE_URL = "http://localhost:8080/api"; // Remplacez par l'URL de votre API

// ==================================================
// Fonctions pour Pays
// ==================================================

async function getAllPays() {
    try {
        const response = await fetch(`${API_BASE_URL}/pays`);
        const data = await response.json();
        document.getElementById("paysResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération des pays :", error);
    }
}

async function getPaysById() {
    const paysId = document.getElementById("paysId").value;
    if (!paysId) {
        alert("Veuillez entrer un ID de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/pays/${paysId}`);
        const data = await response.json();
        document.getElementById("paysResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération du pays :", error);
    }
}

async function addPays() {
    const nomPays = document.getElementById("nomPays").value;
    if (!nomPays) {
        alert("Veuillez entrer un nom de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/pays`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_pays: nomPays }),
        });
        const data = await response.json();
        document.getElementById("paysResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de l'ajout du pays :", error);
    }
}

async function updatePays() {
    const paysId = document.getElementById("updatePaysId").value;
    const nomPays = document.getElementById("updateNomPays").value;

    if (!paysId || !nomPays) {
        alert("Veuillez entrer un ID et un nom de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/pays/${paysId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_pays: nomPays }),
        });
        const data = await response.json();
        document.getElementById("paysResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la mise à jour du pays :", error);
    }
}

async function deletePays() {
    const paysId = document.getElementById("deletePaysId").value;
    if (!paysId) {
        alert("Veuillez entrer un ID de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/pays/${paysId}`, {
            method: "DELETE",
        });
        const data = await response.json();
        document.getElementById("paysResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la suppression du pays :", error);
    }
}

// ==================================================
// Fonctions pour Region
// ==================================================

async function getAllRegions() {
    try {
        const response = await fetch(`${API_BASE_URL}/regions`);
        const data = await response.json();
        document.getElementById("regionResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération des régions :", error);
    }
}

async function getRegionById() {
    const regionId = document.getElementById("regionId").value;
    if (!regionId) {
        alert("Veuillez entrer un ID de région.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/regions/${regionId}`);
        const data = await response.json();
        document.getElementById("regionResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération de la région :", error);
    }
}

async function addRegion() {
    const nomRegion = document.getElementById("nomRegion").value;
    const paysId = document.getElementById("paysIdForRegion").value;

    if (!nomRegion || !paysId) {
        alert("Veuillez entrer un nom de région et un ID de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/regions`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_region: nomRegion, id_pays: paysId }),
        });
        const data = await response.json();
        document.getElementById("regionResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de l'ajout de la région :", error);
    }
}

async function updateRegion() {
    const regionId = document.getElementById("updateRegionId").value;
    const nomRegion = document.getElementById("updateNomRegion").value;
    const paysId = document.getElementById("updatePaysIdForRegion").value;

    if (!regionId || !nomRegion || !paysId) {
        alert("Veuillez entrer un ID de région, un nom de région et un ID de pays.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/regions/${regionId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_region: nomRegion, id_pays: paysId }),
        });
        const data = await response.json();
        document.getElementById("regionResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la mise à jour de la région :", error);
    }
}

async function deleteRegion() {
    const regionId = document.getElementById("deleteRegionId").value;
    if (!regionId) {
        alert("Veuillez entrer un ID de région.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/regions/${regionId}`, {
            method: "DELETE",
        });
        const data = await response.json();
        document.getElementById("regionResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la suppression de la région :", error);
    }
}

// ==================================================
// Fonctions pour Maladie
// ==================================================

async function getAllMaladies() {
    try {
        const response = await fetch(`${API_BASE_URL}/maladies`);
        const data = await response.json();
        document.getElementById("maladieResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération des maladies :", error);
    }
}

async function getMaladieById() {
    const maladieId = document.getElementById("maladieId").value;
    if (!maladieId) {
        alert("Veuillez entrer un ID de maladie.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/maladies/${maladieId}`);
        const data = await response.json();
        document.getElementById("maladieResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération de la maladie :", error);
    }
}

async function addMaladie() {
    const nomMaladie = document.getElementById("nomMaladie").value;
    if (!nomMaladie) {
        alert("Veuillez entrer un nom de maladie.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/maladies`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_maladie: nomMaladie }),
        });
        const data = await response.json();
        document.getElementById("maladieResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de l'ajout de la maladie :", error);
    }
}

async function updateMaladie() {
    const maladieId = document.getElementById("updateMaladieId").value;
    const nomMaladie = document.getElementById("updateNomMaladie").value;

    if (!maladieId || !nomMaladie) {
        alert("Veuillez entrer un ID et un nom de maladie.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/maladies/${maladieId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nom_maladie: nomMaladie }),
        });
        const data = await response.json();
        document.getElementById("maladieResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la mise à jour de la maladie :", error);
    }
}

async function deleteMaladie() {
    const maladieId = document.getElementById("deleteMaladieId").value;
    if (!maladieId) {
        alert("Veuillez entrer un ID de maladie.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/maladies/${maladieId}`, {
            method: "DELETE",
        });
        const data = await response.json();
        document.getElementById("maladieResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la suppression de la maladie :", error);
    }
}

// ==================================================
// Fonctions pour Statistique
// ==================================================

async function getAllStatistiques() {
    try {
        const response = await fetch(`${API_BASE_URL}/statistiques`);
        const data = await response.json();
        document.getElementById("statistiqueResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération des statistiques :", error);
    }
}

async function getStatistiqueById() {
    const statistiqueId = document.getElementById("statistiqueId").value;
    if (!statistiqueId) {
        alert("Veuillez entrer un ID de statistique.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/statistiques/${statistiqueId}`);
        const data = await response.json();
        document.getElementById("statistiqueResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la récupération de la statistique :", error);
    }
}

async function addStatistique() {
    const date = document.getElementById("dateStatistique").value;
    const nouveauMort = document.getElementById("nouveauMort").value;
    const nouveauCas = document.getElementById("nouveauCas").value;
    const nouveauRetabli = document.getElementById("nouveauRetabli").value;
    const totalMort = document.getElementById("totalMort").value;
    const totalCas = document.getElementById("totalCas").value;
    const totalRetabli = document.getElementById("totalRetabli").value;
    const maladieId = document.getElementById("maladieIdForStatistique").value;
    const regionId = document.getElementById("regionIdForStatistique").value;

    if (!date || !nouveauMort || !nouveauCas || !nouveauRetabli || !totalMort || !totalCas || !totalRetabli || !maladieId || !regionId) {
        alert("Veuillez remplir tous les champs.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/statistiques`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                date: date,
                nouveau_mort: parseInt(nouveauMort),
                nouveau_cas: parseInt(nouveauCas),
                nouveau_rétabli: parseInt(nouveauRetabli),
                total_mort: parseInt(totalMort),
                total_cas: parseInt(totalCas),
                total_rétabli: parseInt(totalRetabli),
                id_maladie: maladieId,
                id_region: regionId,
            }),
        });
        const data = await response.json();
        document.getElementById("statistiqueResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de l'ajout de la statistique :", error);
    }
}

async function updateStatistique() {
    const statistiqueId = document.getElementById("updateStatistiqueId").value;
    const date = document.getElementById("dateStatistique").value;
    const nouveauMort = document.getElementById("nouveauMort").value;
    const nouveauCas = document.getElementById("nouveauCas").value;
    const nouveauRetabli = document.getElementById("nouveauRetabli").value;
    const totalMort = document.getElementById("totalMort").value;
    const totalCas = document.getElementById("totalCas").value;
    const totalRetabli = document.getElementById("totalRetabli").value;
    const maladieId = document.getElementById("maladieIdForStatistique").value;
    const regionId = document.getElementById("regionIdForStatistique").value;

    if (!statistiqueId || !date || !nouveauMort || !nouveauCas || !nouveauRetabli || !totalMort || !totalCas || !totalRetabli || !maladieId || !regionId) {
        alert("Veuillez remplir tous les champs.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/statistiques/${statistiqueId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                date: date,
                nouveau_mort: parseInt(nouveauMort),
                nouveau_cas: parseInt(nouveauCas),
                nouveau_rétabli: parseInt(nouveauRetabli),
                total_mort: parseInt(totalMort),
                total_cas: parseInt(totalCas),
                total_rétabli: parseInt(totalRetabli),
                id_maladie: maladieId,
                id_region: regionId,
            }),
        });
        const data = await response.json();
        document.getElementById("statistiqueResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la mise à jour de la statistique :", error);
    }
}

async function deleteStatistique() {
    const statistiqueId = document.getElementById("deleteStatistiqueId").value;
    if (!statistiqueId) {
        alert("Veuillez entrer un ID de statistique.");
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/statistiques/${statistiqueId}`, {
            method: "DELETE",
        });
        const data = await response.json();
        document.getElementById("statistiqueResponse").textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error("Erreur lors de la suppression de la statistique :", error);
    }
}