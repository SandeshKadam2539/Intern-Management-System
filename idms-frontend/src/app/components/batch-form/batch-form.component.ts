import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BatchService } from '../../services/batch.service';

@Component({
    selector: 'app-batch-form',
    templateUrl: './batch-form.component.html',
    styleUrls: ['./batch-form.component.css'],
    standalone: false
})
export class BatchFormComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder, private batchService: BatchService) {
    this.form = this.fb.group({
      startDate: ['', Validators.required]
    });
  }

  submit() {
    if (this.form.invalid) return;
    const start = new Date(this.form.value.startDate);
    const end = new Date(start);
    end.setMonth(end.getMonth() + 6);

    this.batchService.create({
      startDate: start.toISOString().slice(0,10),
      endDate: end.toISOString().slice(0,10)
    }).subscribe({
      next: () => { alert('Batch created'); this.form.reset(); },
      error: err => { console.error(err); alert('Error creating batch'); }
    });
  }
}
