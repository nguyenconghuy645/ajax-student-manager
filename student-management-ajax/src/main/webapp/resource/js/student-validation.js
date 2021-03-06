
$(() => {
    $("#frmCreateStudent").validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        rules: {
            fullName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },

            dateOfBirth: {

            },

            provinceBirth: {

            },

            idCard: {

            },

            telephoneNumbers: {

            },

            email: {

            },

            address: {
                required: true
            }
            // telephoneNumbers: {
                // number: true,
                // minlength: 10,
                // maxlength: 11
            // },
            // password: {
            //     required: false,
            //     // validatePassword: true,
            //     minlength: 5
            // },
            // rePassword: {
            //     // equalTo: "#password",
            //     minlength: 5
            // }
        },
        messages: {
            fullName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },

            dateOfBirth: {

            },

            provinceBirth: {

            },

            idCard: {

            },

            telephoneNumbers: {

            },

            email: {

            },

            address: {

            }
            // telephoneNumbers: {
            //     number: "Vui lòng nhập một số hợp lệ",
            //     minlength: "Hãy nhập ít nhất 10 chữ số",
            //     maxlength: "Hãy nhập tối đã 11 chữ số"
            // },
            // password: {
            //     required: "Bắt buộc nhập mật khẩu",
            //     minlength: "Hãy nhập ít nhất 5 ký tự"
            // },
            // rePassword: {
            //     equalTo: "Hai mật khẩu phải giống nhau",
            //     minlength: "Hãy nhập ít nhất 5 ký tự"
            // }
        },
        submitHandler: function() {
            createStudent();
        }
    });

    $("#frmUpdateStudent").validate({
        onkeyup: function(element) {$(element).valid()},
        onclick: false,
        rules: {
            upFullName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },

            upDateOfBirth: {

            },

            upProvinceBirth: {

            },

            upIdCard: {

            },

            upTelephoneNumbers: {

            },

            upEmail: {

            },

            upAddress: {

            }
        },
        messages: {
            upFullName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },

            upDateOfBirth: {

            },

            upProvinceBirth: {

            },

            upIdCard: {

            },

            upTelephoneNumbers: {

            },

            upEmail: {

            },

            upAddress: {

            }
        },
        submitHandler: function() {
            updateStudent();
        }
    });

    $.validator.addMethod("validatePassword", function (value, element) {
        return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
    }, "Hãy nhập mật khẩu từ 5 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");
});