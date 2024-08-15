document.getElementById('studentForm').addEventListener('submit', function(event) {
    event.preventDefault();
    addStudent();
});

function addStudent() {
    const studentId = document.getElementById('studentId').value;
    const studentName = document.getElementById('studentName').value;
    const studentAge = document.getElementById('studentAge').value;

    fetch('/api/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: studentId,
            name: studentName,
            age: studentAge
        })
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('studentId').value = ''; // Clear the input fields
            document.getElementById('studentName').value = '';
            document.getElementById('studentAge').value = '';

            // Show success message
            const successMessage = document.getElementById('successMessage');
            successMessage.style.display = 'block';
            setTimeout(() => {
                successMessage.style.display = 'none';
            }, 3000);
        })
        .catch(error => console.error('Error:', error));
}
