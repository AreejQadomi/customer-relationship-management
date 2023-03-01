(function (e) {

    document.addEventListener("DOMContentLoaded", function (e) {

        var editCustomerBtns = document.querySelectorAll(".editCustomerBtn");
        editCustomerBtns.forEach(function (elm) {
            elm.addEventListener('click', function (e) {

                var customerId = this.parentElement.querySelector(".customer-id");
                var updateCustomerModal = document.getElementById("update-customer-modal");
                if (updateCustomerModal) {
                    $.ajax({
                        type: 'GET',
                        contentType : 'application/json; charset=utf-8',
                        url: 'showCustomerDetails',
                        data: {id: customerId.value},
                        success: function (result) {
                            console.log("Action:showCustomerDetails - customer retrieved: " + result);

                            // populate form data
                            var updateForm = updateCustomerModal.querySelector("form[name='updateCustomerForm']");
                            updateForm.querySelector("input[name='id']").value = customerId.value;

                            updateForm.querySelector("input[name='firstName']").value = result.firstName;
                            updateForm.querySelector("input[name='lastName']").value = result.lastName;

                            var email = result.email;
                            updateForm.querySelector("input[name='username']").value = email.substring(0, email.indexOf("@"));
                            updateForm.querySelector("input[name='domain']").value = email.substring(email.indexOf("@") + 1, email.indexOf(".com"));
                        }
                    })
                }
            });
        });


    });
})();