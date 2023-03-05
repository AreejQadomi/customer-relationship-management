<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal fade" id="delete-customer-modal" tabindex="-1" role="dialog" aria-labelledby="delete-customer-modal-label" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <span class="modal-title lead" id="delete-customer-modal-label">Delete customer</span>
                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <form action="deleteCustomer" method="GET" name="deleteCustomerForm">
                <div class="modal-body">
                    <div class="container-fluid">
                        <div class="row justify-content-center">
                            <div class="col-md-11">
                                <p class="lead">Are you sure you want to delete the customer: </p>

                                <div class="form-floating lead">
                                    <strong>
                                        <span class="lastName">lastName, </span>
                                        <span class="firstName">firstName -</span>
                                        <span class="email">email</span>
                                    </strong>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button id="deleteCustomerBtn" type="submit" class="btn btn-danger">Delete</button>
                </div>

                <input id="id-input" type="hidden" name="id"/>
            </form>
        </div>
    </div>
</div>