
class App {
    static BASE_URL_STUDENT = "http://localhost:8080/api/students";
    static BASE_URL_PROVINCE_BIRTH = "http://localhost:8080/api/provinceBirths";

    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}

class Student {
    constructor(id, fullName, dateOfBirth, idCard, telephoneNumbers, email, address, provinceBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.provinceBirth = provinceBirth;
        this.idCard = idCard;
        this.telephoneNumbers = telephoneNumbers;
        this.email = email;
        this.address = address;
    }
}
